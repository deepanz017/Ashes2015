package peelu.satta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import peelu.satta.config.AppProperties;
import peelu.satta.frontend.forms.PicksForm;
import peelu.satta.model.Player;
import peelu.satta.model.SattaUserDetails;
import peelu.satta.service.PlayerService;
import peelu.satta.service.exceptions.PickAlreadyExisting;
import peelu.satta.service.impl.PickService;

import java.io.IOException;
import java.util.List;

@Controller
public class PicksController {
    @Autowired
    PlayerService playerService;

    @Autowired
    AppProperties appProperties;

    @Autowired
    PickService pickService;


    @RequestMapping(value = "/pick/save", method = RequestMethod.GET)
    public String selectPicks(ModelMap model) throws IOException {

        SattaUserDetails activeUser = (SattaUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!pickService.pickRequired(activeUser.getId(), appProperties.getCurrentMatchId()))
            return "redirect:/scorecard/liveSattaScore";
        PicksForm pick = new PicksForm();
        List<Player> playersInMatch = playerService.getPlayerListinMatch();
        model.addAttribute("pick", pick);
        model.addAttribute("playersInMatch", playersInMatch);
        return "pick/choosePicks";
    }


    @RequestMapping(value = "/pick/save", method = RequestMethod.POST)
    public String savePicks(@ModelAttribute PicksForm pickData, BindingResult result,
                            WebRequest request) throws PickAlreadyExisting {
        SattaUserDetails activeUser = (SattaUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long matchId = appProperties.getCurrentMatchId();

            pickService.savePick(activeUser.getId(), matchId, pickData);
            return "redirect:/scorecard/liveSattaScore";

    }
}
