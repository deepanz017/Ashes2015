package peelu.satta.frontend.forms;

import org.hibernate.validator.constraints.NotEmpty;
import peelu.satta.config.enums.SattaTeam;

public class PicksForm {
    @NotEmpty
    private Long pick1;

    @NotEmpty
    private Long pick2;

    @NotEmpty
    private Long pick3;

    @NotEmpty
    private Long pick4;

    @NotEmpty
    private Long pick5;

    @NotEmpty
    private Long pick6;

    @NotEmpty
    private String team;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Long getPick1() {
        return pick1;
    }

    public void setPick1(Long pick1) {
        this.pick1 = pick1;
    }

    public Long getPick2() {
        return pick2;
    }

    public void setPick2(Long pick2) {
        this.pick2 = pick2;
    }

    public Long getPick3() {
        return pick3;
    }

    public void setPick3(Long pick3) {
        this.pick3 = pick3;
    }

    public Long getPick4() {
        return pick4;
    }

    public void setPick4(Long pick4) {
        this.pick4 = pick4;
    }

    public Long getPick5() {
        return pick5;
    }

    public void setPick5(Long pick5) {
        this.pick5 = pick5;
    }

    public Long getPick6() {
        return pick6;
    }

    public void setPick6(Long pick6) {
        this.pick6 = pick6;
    }
}
