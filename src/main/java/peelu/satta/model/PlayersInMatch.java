package peelu.satta.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dabroal on 09/07/15.
 */
public class PlayersInMatch {

    private Team homeTeam;
    private Team awayTeam;




    public PlayersInMatch(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Override
    public String toString() {
        return "PlayersInMatch{" +
                "homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                '}';
    }

    public List<Player> getPlayerListInMatch(){
        List<Player> playerList= new ArrayList<Player>();
        playerList.addAll(homeTeam.getPlayers());
        playerList.addAll(awayTeam.getPlayers());
        return playerList;
    }

    public Map<Integer, Player> getPlayerObjectsInMatch(){
        Map<Integer, Player> playerMap = new HashMap<Integer, Player>();
        for(Player player: getPlayerListInMatch()){
            playerMap.put(player.getPlayerId(), player);
        }
        return playerMap;
    }
}
