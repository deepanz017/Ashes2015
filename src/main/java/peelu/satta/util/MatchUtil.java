package peelu.satta.util;

import com.google.gson.Gson;

import org.springframework.stereotype.Service;
import peelu.satta.model.*;


@Service
public class MatchUtil {
    public MatchScoreCard getMatchScoreCardFromApiResponse(String apiResponse){
        Gson gson = new Gson();
        MatchScoreCard matchScoreCard = gson.fromJson(apiResponse, MatchScoreCard.class);
        return matchScoreCard;
    }




}
