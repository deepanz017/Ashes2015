package peelu.satta.model;

import java.util.List;

/**
 * Created by dabroal on 11/07/15.
 */
public class UserScore {
    String name;
    List<Player> picks;
    Player superpick;
    double userScore;

    public UserScore(String name, List<Player> picks, Player superpick) {
        this.name = name;
        this.picks = picks;
        this.superpick = superpick;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPicks() {
        return picks;
    }

    public void setPicks(List<Player> picks) {
        this.picks = picks;
    }

    public Player getSuperpick() {
        return superpick;
    }

    public void setSuperpick(Player superpick) {
        this.superpick = superpick;
    }

    public double getUserScore() {
        return userScore;
    }

    public void setUserScore(double userScore) {
        this.userScore = userScore;
    }

    public double getUpdatedUserScore(FantasyScoreCard fantasyScoreCard){
        double score = 0;
        for(Player player: picks){
            score += fantasyScoreCard.getPlayerScores().get(player.getPlayerId()).getScore();
        }
        score += 0.5 * fantasyScoreCard.getPlayerScores().get(superpick.getPlayerId()).getScore();
        userScore = score;
        return score;
    }

}
