package peelu.satta.model;

/**
 * Created by dabroal on 09/07/15.
 */
public class Player {
    private Integer playerId;
    private String fullName;

    @Override
    public String toString() {
        return "Player{" +"</br>" +
                "fullName='" + fullName + '\'' +"</br>" +
                ", playerId=" + playerId +"</br>" +
                '}';
    }

    public Player(Integer playerId, String fullName) {
        this.playerId = playerId;
        this.fullName = fullName;
    }

    private Integer score;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
