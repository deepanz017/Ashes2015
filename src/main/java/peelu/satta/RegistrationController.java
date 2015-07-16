package peelu.satta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import peelu.satta.config.enums.SocialMediaService;
import peelu.satta.frontend.forms.RegistrationForm;
import peelu.satta.model.SattaUserDetails;
import peelu.satta.persistence.entity.User;
import peelu.satta.service.UserService;
import peelu.satta.service.exceptions.DuplicateEmailException;
import peelu.satta.util.SecurityUtil;

import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class RegistrationController {
    private UserService service;


    @Autowired
    public RegistrationController(UserService service) {
        this.service = service;
    }

    @RequestMapping(value ="/user/register", method = RequestMethod.POST)
    public String registerUserAccount(@Valid @ModelAttribute("user") RegistrationForm userAccountData,
                                      BindingResult result,
                                      WebRequest request) throws DuplicateEmailException {
        if (result.hasErrors()) {
            return "user/registrationForm";
        }

        User registered = createUserAccount(userAccountData, result);

        if (registered == null) {
            return "user/registrationForm";
        }
        SecurityUtil.logInUser(registered);
        ProviderSignInUtils.handlePostSignUp(registered.getEmail(), request);

        return "redirect:/";
    }

    private User createUserAccount(RegistrationForm userAccountData, BindingResult result) {
        User registered = null;

        try {
            registered = service.registerNewUserAccount(userAccountData);
        }
        catch (DuplicateEmailException ex) {
            addFieldError(
                    "user",
                    "email",
                    userAccountData.getEmail(),
                    "NotExist.user.email",
                    result);
        }

        return registered;
    }

    private void addFieldError(String objectName, String fieldName, String fieldValue,  String errorCode, BindingResult result) {
        FieldError error = new FieldError(
                objectName,
                fieldName,
                fieldValue,
                false,
                new String[]{errorCode},
                new Object[]{},
                errorCode
        );

        result.addError(error);
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {

        Connection<?> connection = ProviderSignInUtils.getConnection(request);

        RegistrationForm registration = createRegistrationDTO(connection);
        model.addAttribute("user", registration);

        return "user/registrationForm";
    }

    private RegistrationForm createRegistrationDTO(Connection<?> connection) {
        RegistrationForm dto = new RegistrationForm();

        if (connection != null) {
            UserProfile socialMediaProfile = connection.fetchUserProfile();
            dto.setEmail(socialMediaProfile.getEmail());
            dto.setFirstName(socialMediaProfile.getFirstName());
            dto.setLastName(socialMediaProfile.getLastName());

            ConnectionKey providerKey = connection.getKey();
            dto.setSignInProvider(SocialMediaService.valueOf(providerKey.getProviderId().toUpperCase()));
        }

        return dto;
    }
}
