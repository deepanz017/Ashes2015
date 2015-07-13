package peelu.satta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import peelu.satta.model.*;
import peelu.satta.service.APIHelper;
import peelu.satta.service.PlayerService;
import peelu.satta.service.ScoreCardService;
import peelu.satta.service.UserDataHolderService;
import peelu.satta.util.MatchUtil;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    APIHelper APIHelper;

    @Autowired
    MatchUtil matchUtil;

    @Autowired
    PlayerService playerService;

    @Autowired
    ScoreCardService scoreCardService;

    @Autowired
    UserDataHolderService userDataHolderService;

    private String matchTitle;
    private String jsonString;


    @RequestMapping(value = "/scorecard", method = RequestMethod.GET)
    public String scoreCard(ModelMap model){
        try {
            MatchScoreCard scoreCard = scoreCardService.getMatchScoreCard();
            PlayersInMatch playersInMatch = playerService.getPlayersInMatch(37525);
            FantasyScoreCard fantasyScoreCard = scoreCardService.getFantasyScoreCard(scoreCard, playersInMatch);


//            userDataHolderService.updateUsers();
//            userDataHolderService.updateScores(fantasyScoreCard);
//            List<UserScore> chutiyas = userDataHolderService.getChutiyas();
//            List<UserScore> madarchods = userDataHolderService.getMadarChods();

//            model.addAttribute("chutiyas", chutiyas);
//            model.addAttribute("madarchods", madarchods);
            model.addAttribute("scorecard", scoreCard.toString());
            model.addAttribute("fantasyScoreCard", fantasyScoreCard);
        } catch (IOException e) {
            model.addAttribute("scorecard", "Oops, error!!!");
        }
        return "scoreCard";

    }


    @RequestMapping(value = "/userHomePage", method = RequestMethod.GET)
    @ResponseBody
    String login(@RequestParam String userName){

        return "Peelu";
    }


    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public String players(ModelMap model){
        try {
            PlayersInMatch playersInMatch = playerService.getPlayersInMatch(37525);
            model.addAttribute("players", playersInMatch.toString());
        } catch (IOException e) {
            model.addAttribute("players", "Oops, error!!!");
        }
        return "players";

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(ModelMap model){
        return "hello";
    }



}