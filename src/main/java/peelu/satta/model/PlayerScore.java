package peelu.satta.model;

/**
 * Created by dabroal on 11/07/15.
 */
public class PlayerScore {
    Integer playerId;
    Integer score;
    String fullName;


    public PlayerScore(Integer playerId, Integer score, String fullName) {
        this.playerId = playerId;
        this.score = score;
        this.fullName = fullName;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
