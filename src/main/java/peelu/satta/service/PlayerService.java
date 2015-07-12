package peelu.satta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peelu.satta.model.PlayersInMatch;
import peelu.satta.util.PlayerUtil;

import java.io.BufferedReader;
import java.io.IOException;


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

    private static String PLAYERSAPI = "http://apinew.cricket.com.au/players/bymatch/1448/37525?format=json";

    public PlayersInMatch getPlayersInMatch(Integer matchId) throws IOException {

        if(matchId == null) return null;
        if (playersInMatch != null) return playersInMatch;

        String ApiResponse = apiHelper.responsefromAPI(PLAYERSAPI);
        playersInMatch =  playerUtil.getPlayersInMatchFromApiResponse(ApiResponse);
        return playersInMatch;
    }
}
