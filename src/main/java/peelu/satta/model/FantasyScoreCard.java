package peelu.satta.model;

import java.util.Map;

/**
 * Created by dabroal on 11/07/15.
 */
public class FantasyScoreCard {
    private Map<Integer, PlayerScore> playerScores;


    public FantasyScoreCard(Map<Integer, PlayerScore> playerScores) {
        this.playerScores = playerScores;
    }

    public Map<Integer, PlayerScore> getPlayerScores() {
        return playerScores;
    }

    public void setPlayerScores(Map<Integer, PlayerScore> playerScores) {
        this.playerScores = playerScores;
    }
}
