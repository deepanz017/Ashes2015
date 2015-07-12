package peelu.satta.model;

import java.util.List;

/**
 * Created by dabroal on 09/07/15.
 */
public class ScoreCard {

    private List<Innings> innings;

    public ScoreCard(List<Innings> innings) {
        this.innings = innings;
    }

    public List<Innings> getInnings() {
        return innings;
    }

    public void setInnings(List<Innings> innings) {
        this.innings = innings;
    }

}
