package peelu.satta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peelu.satta.config.AppProperties;
import peelu.satta.model.Player;
import peelu.satta.model.PlayersInMatch;
import peelu.satta.util.PlayerUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;


/**
 * Created by dabroal on 09/07/15.
 */
@Service
public class PlayerService{
    @Autowired
    APIHelper apiHelper;

    @Autowired
    PlayerUtil playerUtil;

    PlayersInMatch playersInMatch;

    @Autowired
    AppProperties appProperties;

    private static String PLAYERSAPI = "http://apinew.cricket.com.au/players/bymatch/1448/";

    public PlayersInMatch getPlayersInMatch() throws IOException {

        Long matchId = appProperties.getCurrentMatchId();
        if(matchId == null) return null;
        if (playersInMatch != null) return playersInMatch;

        String ApiResponse = apiHelper.responsefromAPI(getApiUrl(matchId));
        playersInMatch =  playerUtil.getPlayersInMatchFromApiResponse(ApiResponse);
        return playersInMatch;
    }

    public List<Player> getPlayerListinMatch() throws IOException {
        return getPlayersInMatch().getPlayerListInMatch();

    }

    private void setUpPlayersInMatch() {

    }

    private String getApiUrl(Long matchId){
        return PLAYERSAPI + String.valueOf(matchId) + "?format=json";
    }
}
