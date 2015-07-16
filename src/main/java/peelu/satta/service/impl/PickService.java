package peelu.satta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peelu.satta.config.enums.SattaTeam;
import peelu.satta.frontend.forms.PicksForm;
import peelu.satta.persistence.entity.Pick;
import peelu.satta.persistence.repositories.PickRepository;
import peelu.satta.service.exceptions.PickAlreadyExisting;

@Service
public class PickService {
    @Autowired
    PickRepository pickRepository;


    public Pick savePick(Long userId, Long matchId, PicksForm pickData) throws PickAlreadyExisting {
        Pick pick = pickRepository.findByUserIdAndMatchId(userId, matchId);
        if(pick == null){
            Pick pickToBeSaved = Pick.getBuilder()
                    .matchId(matchId)
                    .user(userId)
                    .team(SattaTeam.valueOf(pickData.getTeam()))
                    .players(pickData.getPick1(), pickData.getPick2(), pickData.getPick3(), pickData.getPick4(), pickData.getPick5(), pickData.getPick6())
                    .build();

            pickRepository.save(pickToBeSaved);
            return pickToBeSaved;

        }
        else {
            throw new PickAlreadyExisting("Pick for user" + String.valueOf(userId + "for match" + String.valueOf(matchId)) + " already existing");
        }
    }

    public boolean pickRequired(Long userId, Long matchId){
        Pick pick = pickRepository.findByUserIdAndMatchId(userId, matchId);
        if(pick == null){
            return true;
        }
        return false;

    }

}
