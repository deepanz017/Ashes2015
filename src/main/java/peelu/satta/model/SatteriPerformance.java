package peelu.satta.model;

import peelu.satta.config.enums.SattaTeam;

import java.util.List;

/**
 * Created by dabroal on 16/07/15.
 */
public class SatteriPerformance {


    PlayerScore superPlayer;

    public PlayerScore getSuperPlayer() {
        return superPlayer;
    }

    public void setSuperPlayer(PlayerScore superPlayer) {
        this.superPlayer = superPlayer;
    }

    SattaTeam sattaTeam;

    public SattaTeam getSattaTeam() {
        return sattaTeam;
    }

    public void setSattaTeam(SattaTeam sattaTeam) {
        this.sattaTeam = sattaTeam;
    }

    List<PlayerScore> playerScores;
    Double satteriScore;

    public SatteriPerformance(List<PlayerScore> playerScores, Double satteriScore, PlayerScore superPlayer) {
        this.playerScores = playerScores;
        this.satteriScore = satteriScore;
        this.superPlayer = superPlayer;
    }

    public List<PlayerScore> getPlayerScores() {
        return playerScores;
    }

    public void setPlayerScores(List<PlayerScore> playerScores) {
        this.playerScores = playerScores;
    }

    public Double getSatteriScore() {
        return satteriScore;
    }

    public void setSatteriScore(Double satteriScore) {
        this.satteriScore = satteriScore;
    }
}
