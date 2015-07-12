package peelu.satta.service;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peelu.satta.model.FantasyScoreCard;
import peelu.satta.model.Player;
import peelu.satta.model.UserScore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserDataHolderService {

    @Autowired
    PlayerService playerService;

    private static List<Player> dickyPicks= new ArrayList<Player>();
    private static List<Player> tattaPicks= new ArrayList<Player>();
    private static List<Player> sarafPicks= new ArrayList<Player>();
    private static List<Player> tripsPicks= new ArrayList<Player>();
    private static List<Player> khanniPicks= new ArrayList<Player>();
    private static List<Player> xapaPicks= new ArrayList<Player>();

    UserScore khanniScore, xapaScore, tripsScore, sarafScore, dickyScore, tattaScore;

    private List<UserScore> userScores;

    public void updateUsers() throws IOException {
        Player Stokes = playerService.getPlayersInMatch(37525).getPlayerObjectsInMatch().get(4489);
        Player Starc = playerService.getPlayersInMatch(37525).getPlayerObjectsInMatch().get(4910);
        Player Anderson = playerService.getPlayersInMatch(37525).getPlayerObjectsInMatch().get(3065);
        Player Ali = playerService.getPlayersInMatch(37525).getPlayerObjectsInMatch().get(3992);
        Player Broad = playerService.getPlayersInMatch(37525).getPlayerObjectsInMatch().get(3425);
        Player Ballance = playerService.getPlayersInMatch(37525).getPlayerObjectsInMatch().get(4051);
        Player Cook = playerService.getPlayersInMatch(37525).getPlayerObjectsInMatch().get(3297);
        Player Smith = playerService.getPlayersInMatch(37525).getPlayerObjectsInMatch().get(4552);
        Player Root = playerService.getPlayersInMatch(37525).getPlayerObjectsInMatch().get(4541);
        Player Johnson = playerService.getPlayersInMatch(37525).getPlayerObjectsInMatch().get(3334);
        Player Buttler = playerService.getPlayersInMatch(37525).getPlayerObjectsInMatch().get(4456);
        Player Warner = playerService.getPlayersInMatch(37525).getPlayerObjectsInMatch().get(4275);
        Player Voges = playerService.getPlayersInMatch(37525).getPlayerObjectsInMatch().get(3501);
        Player Watson = playerService.getPlayersInMatch(37525).getPlayerObjectsInMatch().get(3017);




        if(dickyPicks.isEmpty()) {
            dickyPicks.add(playerService.getPlayersInMatch(37525).getPlayerObjectsInMatch().get(4489));//Stokes
            dickyPicks.add(playerService.getPlayersInMatch(37525).getPlayerObjectsInMatch().get(4552));//Smith
            dickyPicks.add(playerService.getPlayersInMatch(37525).getPlayerObjectsInMatch().get(3992));//Ali
            dickyPicks.add(playerService.getPlayersInMatch(37525).getPlayerObjectsInMatch().get(3067));//Clarke
            dickyPicks.add(playerService.getPlayersInMatch(37525).getPlayerObjectsInMatch().get(4818));//Hazlewood
            dickyPicks.add(Broad);
        }
        dickyScore = new UserScore("Dicky", dickyPicks, Stokes);

//        Dicky:  Stokes*1.5 + Smith + Ali + Clarke + Broad + Hazlewood

//        Tatta : Stokes*1.5 + Starc + Anderson + Ali + Ballance + Cook)

        if(tattaPicks.isEmpty()) {
            tattaPicks.add(Stokes);
            tattaPicks.add(Starc);
            tattaPicks.add(Anderson);
            tattaPicks.add(Ali);
            tattaPicks.add(Ballance);
            tattaPicks.add(Cook);
        }

        tattaScore = new UserScore("Tatta", tattaPicks, Stokes);

//Smith + Root + Johnson*1.5 + Broad + Warner + Buttler
        if(sarafPicks.isEmpty()) {
            sarafPicks.add(Smith);
            sarafPicks.add(Root);
            sarafPicks.add(Johnson);
            sarafPicks.add(Broad);
            sarafPicks.add(Buttler);
            sarafPicks.add(Warner);
        }
        sarafScore = new UserScore("Saraf", sarafPicks, Johnson);


//        Root + Starc*1.5 + Warner + Anderson + Watson + Voges

        if(tripsPicks.isEmpty()) {
            tripsPicks.add(Root);
            tripsPicks.add(Starc);
            tripsPicks.add(Warner);
            tripsPicks.add(Anderson);
            tripsPicks.add(Watson);
            tripsPicks.add(Voges);
        }
        tripsScore = new UserScore("Trips", tripsPicks, Starc);

//        Cook + Smith*1.5 + Warner + Broad + Ali + Watson
        if(khanniPicks.isEmpty()) {
            khanniPicks.add(Cook);
            khanniPicks.add(Smith);
            khanniPicks.add(Warner);
            khanniPicks.add(Broad);
            khanniPicks.add(Watson);
            khanniPicks.add(Ali);
        }
        khanniScore = new UserScore("Khanni", khanniPicks, Smith);


//        Root*1.5 + Stokes + Starc + Ballance + Anderson + Johnson

        if(xapaPicks.isEmpty()) {
            xapaPicks.add(Root);
            xapaPicks.add(Stokes);
            xapaPicks.add(Starc);
            xapaPicks.add(Ballance);
            xapaPicks.add(Anderson);
            xapaPicks.add(Johnson);
        }
        xapaScore = new UserScore("Xapa", xapaPicks, Root);



    }
    public List<UserScore> getChutiyas(){
        List<UserScore> chutiyas = new ArrayList<UserScore>();
        chutiyas.add(xapaScore);
        chutiyas.add(sarafScore);
        chutiyas.add(dickyScore);
        return chutiyas;
    }

    public List<UserScore> getMadarChods(){
        List<UserScore> madarChods = new ArrayList<UserScore>();
        madarChods.add(khanniScore);
        madarChods.add(tripsScore);
        madarChods.add(tattaScore);
        return madarChods;
    }

    public void updateScores(FantasyScoreCard fantasyScoreCard){
        for(UserScore userScore: getMadarChods()){
            userScore.getUpdatedUserScore(fantasyScoreCard);
        }
        for(UserScore userScore: getChutiyas()){
            userScore.getUpdatedUserScore(fantasyScoreCard);
        }
    }

}
