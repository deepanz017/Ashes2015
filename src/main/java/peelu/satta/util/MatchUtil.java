package peelu.satta.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peelu.satta.model.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchUtil {
    public MatchScoreCard getMatchScoreCardFromApiResponse(String apiResponse){
        Gson gson = new Gson();
        MatchScoreCard matchScoreCard = gson.fromJson(apiResponse, MatchScoreCard.class);
        return matchScoreCard;
    }




}
