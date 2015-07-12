package peelu.satta.model;

import java.util.List;

/**
 * Created by dabroal on 09/07/15.
 */
public class Innings {
    List<PlayerPerformance> batsmen;
    List<PlayerPerformance> bowlers;

    public List<PlayerPerformance> getBatsmen() {
        return batsmen;
    }

    public void setBatsmen(List<PlayerPerformance> batsmen) {
        this.batsmen = batsmen;
    }

    public List<PlayerPerformance> getBowlers() {
        return bowlers;
    }

    public void setBowlers(List<PlayerPerformance> bowlers) {
        this.bowlers = bowlers;
    }
}
