package peelu.satta.service;


import peelu.satta.frontend.forms.RegistrationForm;
import peelu.satta.persistence.entity.User;
import peelu.satta.service.exceptions.DuplicateEmailException;

public interface UserService {
    User registerNewUserAccount(RegistrationForm userAccountData) throws DuplicateEmailException;
}


//    private List<UserScore> userScoreList;
//
//    public List<UserScore> getUserScoreList() {
//        if( userScoreList == null )
//            setUserScoreList();
//    }
//
//    public void setUserScoreList() {
//
//    }
//}
