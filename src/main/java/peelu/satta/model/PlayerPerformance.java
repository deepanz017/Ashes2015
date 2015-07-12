package peelu.satta.model;

/**
 * Created by dabroal on 09/07/15.
 */
public class PlayerPerformance {
    private Integer id;
    private String name;

    private String maidens;
    private String wickets;

    private String runs;
    private String balls;

    private Integer score;

    public Integer getScore(){
        if(score!=null) return score;
        score = 0;
        if(runs != null) score += getRuns();
        if(wickets != null ) score += getWickets()*25;
        score = score + 10 *((Integer) score/50);
        return score;
    }

    public PlayerPerformance(Integer id, String name, String maidens, String wickets, String runs, String balls) {
        this.id = id;
        this.name = name;
        this.maidens = maidens;
        this.wickets = wickets;
        this.runs = runs;
        this.balls = balls;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaidens() {
        return getIntegerValueof(maidens);
    }



    public Integer getIntegerValueof(String fieldName) {
        Integer fieldInt = null;
        try {
            fieldInt = Integer.parseInt(fieldName);
        }
        catch (NumberFormatException e) {
            fieldInt = 0;
        }
        return fieldInt;
    }

    public void setMaidens(String maidens) {
        this.maidens = maidens;
    }

    public Integer getWickets() {
        return getIntegerValueof(wickets);
    }

    public void setWickets(String wickets) {
        this.wickets = wickets;
    }

    public Integer getRuns() {
        return getIntegerValueof(runs);
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }

    public Integer getBalls() {
        return getIntegerValueof(balls);
    }

    public void setBalls(String balls) {
        this.balls = balls;
    }
}
