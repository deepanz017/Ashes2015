package peelu.satta.util;


import org.springframework.stereotype.Service;
import peelu.satta.model.Match;
import peelu.satta.model.PlayersInMatch;
import com.google.gson.Gson;

import java.io.BufferedReader;

@Service
public class PlayerUtil {

    public PlayersInMatch getPlayersInMatchFromApiResponse(String ApiResponse){
        Gson gson = new Gson();
        Match match = gson.fromJson(ApiResponse, Match.class);
        return match.getPlayersInMatch();
    }

}
