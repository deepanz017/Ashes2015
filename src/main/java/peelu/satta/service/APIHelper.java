package peelu.satta.service;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.*;
import org.springframework.stereotype.Service;
import org.apache.http.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@Service
public class APIHelper {

    public JSONObject getMatchJson() {
        if(matchJson == null){
            try {
                getJsonfromCricInfo(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return matchJson;
    }

    public void setMatchJson(JSONObject matchJson) {
        this.matchJson = matchJson;
    }
    private static String url = "http://apinew.cricket.com.au/players/bymatch/1448/37525?format=json";
    //http://caprodseacs03.cloudapp.net/swagger-ui/index.html#!/scorecards



    public static void setUrl(String url) {
        APIHelper.url = url;
    }

    private JSONObject matchJson;

    public JSONObject getJsonfromCricInfo(String url) throws IOException {
        if (matchJson == null ) {
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(url);


            HttpResponse response = null;
            System.out.println("\nSending 'GET' request to URL : " + url);
            try {
                response = client.execute(request);
            } catch (IOException e) {
                System.out.println(new StringBuilder().append("Error while getting Json from : ").append(url).toString());
                e.printStackTrace();
            }


            System.out.println("Response Code : " +
                    response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            setMatchJson(new JSONObject(String.valueOf(result)));


        }
        return matchJson;
    }

    public String responsefromAPI(String url) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);


        HttpResponse response = null;
        System.out.println("\nSending 'GET' request to URL : " + url);
        try {
            response = client.execute(request);
        } catch (IOException e) {
            System.out.println(new StringBuilder().append("Error while getting Json from : ").append(url).toString());
            e.printStackTrace();
        }


        System.out.println("Response Code : " +
                response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        return String.valueOf(result);

    }




    public String getMatchTitlefromJson() throws IOException {
        if(matchJson == null){
            getJsonfromCricInfo(url);
        }
        return matchJson.getString("description");
    }



}
