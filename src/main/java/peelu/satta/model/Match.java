package peelu.satta.model;

import java.util.List;


public class Match {



    protected PlayersInMatch playersInMatch;


    @Override
    public String toString() {
        return "Match{" +
                "playersInMatch=" + playersInMatch +
                '}';
    }

    public Match(PlayersInMatch playersInMatch) {
        this.playersInMatch = playersInMatch;
    }

    public PlayersInMatch getPlayersInMatch() {
        return playersInMatch;
    }

    public void setPlayersInMatch(PlayersInMatch playersInMatch) {
        this.playersInMatch = playersInMatch;
    }
}
