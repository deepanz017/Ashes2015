package peelu.satta.model;

import java.util.List;

/**
 * Created by dabroal on 09/07/15.
 */
public class Team {
    List<Player> players;

    @Override
    public String toString() {
        return "Team{" +
                "players=" + players +
                '}';
    }

    public Team(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
