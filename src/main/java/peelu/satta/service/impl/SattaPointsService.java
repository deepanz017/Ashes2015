package peelu.satta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peelu.satta.config.enums.SattaTeam;
import peelu.satta.model.*;
import peelu.satta.persistence.entity.Pick;
import peelu.satta.persistence.entity.User;
import peelu.satta.persistence.repositories.PickRepository;
import peelu.satta.persistence.repositories.UserRepository;
import peelu.satta.service.ScoreCardService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SattaPointsService {
    @Autowired
    PickRepository pickRepository;

    @Autowired
    ScoreCardService scoreCardService;


    @Autowired
    UserRepository userRepository;
    private Double Madarchod_points;
    private Double Chutiya_points;




    public SattaTeamWisecoreCard getLiveSattaScore() throws IOException {
        Map<SattaTeam, Double> teamScores = new HashMap<>();
        for(SattaTeam sattaTeam: SattaTeam.values()){
            teamScores.put(sattaTeam, Double.valueOf(0));
        }
        Double orig_score = Double.valueOf(0);
        Map<User, SatteriPerformance> satteriScoreMap = new HashMap<>();
        List<Pick> picks = pickRepository.findAll();
        for(Pick pick: picks){
            SatteriPerformance satteriPerformance = convertPickToPlayerScoreList(pick);
            satteriPerformance.setSattaTeam(pick.getSattaTeam());
            User user = userRepository.findById(pick.getUserId());
            satteriScoreMap.put(user, satteriPerformance);
            orig_score = teamScores.get(pick.getSattaTeam());
            orig_score += satteriPerformance.getSatteriScore();
            teamScores.put(pick.getSattaTeam(), orig_score);

        }
        return new SattaTeamWisecoreCard(satteriScoreMap, teamScores);
    }

    SatteriPerformance convertPickToPlayerScoreList(Pick pick) throws IOException {
        Double satteriScore = Double.valueOf(0);
        List<PlayerScore> playerScores = new ArrayList<>();
        FantasyScoreCard liveFantasyScoreCard = scoreCardService.getLiveFantasyScoreCard();
        for(Integer playerId: pick.getPlayerList()){
            satteriScore +=liveFantasyScoreCard.getPlayerScores().get(playerId).getScore();
            playerScores.add(liveFantasyScoreCard.getPlayerScores().get(playerId));
        }
        satteriScore += 0.5 * liveFantasyScoreCard.getPlayerScores().get(pick.getPlayerId1().intValue()).getScore();
        return new SatteriPerformance(playerScores, satteriScore, liveFantasyScoreCard.getPlayerScores().get(pick.getPlayerId1().intValue()));
    }
}
