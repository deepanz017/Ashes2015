package peelu.satta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peelu.satta.model.*;
import peelu.satta.util.MatchUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dabroal on 09/07/15.
 */
@Service
public class ScoreCardService {

    @Autowired
    APIHelper apiHelper;

    @Autowired
    MatchUtil matchUtil;

    private static String SCORECARD_URL = "http://apinew.cricket.com.au/scorecards/full/1448/37525?format=json";

    public MatchScoreCard getMatchScoreCard() throws IOException {

        String apiResponse = apiHelper.responsefromAPI(SCORECARD_URL);

        return matchUtil.getMatchScoreCardFromApiResponse(apiResponse);
    }

    public FantasyScoreCard getFantasyScoreCard(MatchScoreCard matchScoreCard, PlayersInMatch playersInMatch){
        Map<Integer, PlayerScore> playerScores = new HashMap<Integer, PlayerScore>();
        for(Player player: playersInMatch.getPlayerListInMatch()) playerScores.put(player.getPlayerId(), new PlayerScore(player.getPlayerId(), 0, player.getFullName()));
        for(Innings innings: matchScoreCard.getFullScorecard().getInnings()){
            for(PlayerPerformance playerPerformance: innings.getBatsmen()){
                Integer score = playerScores.get(playerPerformance.getId()).getScore();
                score += playerPerformance.getScore();
                playerScores.get(playerPerformance.getId()).setScore(score);
            }
            for(PlayerPerformance playerPerformance: innings.getBowlers()){
                Integer score = playerScores.get(playerPerformance.getId()).getScore();
                score += playerPerformance.getScore();
                playerScores.get(playerPerformance.getId()).setScore(score);
            }
        }
        return new FantasyScoreCard(playerScores);


    }


}
