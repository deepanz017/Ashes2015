package peelu.satta.model;

import peelu.satta.config.enums.SattaTeam;
import peelu.satta.persistence.entity.User;

import java.util.Map;

/**
 * Created by dabroal on 16/07/15.
 */
public class SattaTeamWisecoreCard {

    Map<User, SatteriPerformance> userWisePerformance;
    Map<SattaTeam, Double> teamScores;


    public SattaTeamWisecoreCard(Map<User, SatteriPerformance> userWisePerformance, Map<SattaTeam, Double> teamScores) {
        this.userWisePerformance = userWisePerformance;
        this.teamScores = teamScores;
    }

    public Map<User, SatteriPerformance> getUserWisePerformance() {
        return userWisePerformance;
    }

    public void setUserWisePerformance(Map<User, SatteriPerformance> userWisePerformance) {
        this.userWisePerformance = userWisePerformance;
    }

    public Map<SattaTeam, Double> getTeamScores() {
        return teamScores;
    }

    public void setTeamScores(Map<SattaTeam, Double> teamScores) {
        this.teamScores = teamScores;
    }
}
