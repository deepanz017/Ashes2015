package peelu.satta.persistence.entity;

import peelu.satta.config.enums.SattaTeam;
import peelu.satta.model.SattaUserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name="pick")
public class Pick {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name="userId", nullable = false)
    Long userId;

    @Column(name="matchId", nullable=false)
    Long matchId;

    @Column(name="pick1")
    Long playerId1;

    @Column(name="pick2")
    Long playerId2;

    @Column(name="pick3")
    Long playerId3;

    @Column(name="pick4")
    Long playerId4;

    @Column(name="pick5")
    Long playerId5;

    @Column(name="pick6")
    Long playerId6;

    @Enumerated
    private SattaTeam team;

    public List<Integer> getPlayerList(){
        List<Integer> playerList = new ArrayList<>();
        playerList.add(playerId1!= null ? playerId1.intValue() : null);
        playerList.add(playerId2!= null ? playerId2.intValue() : null);
        playerList.add(playerId3!= null ? playerId3.intValue() : null);
        playerList.add(playerId4!= null ? playerId4.intValue() : null);
        playerList.add(playerId5!= null ? playerId5.intValue() : null);
        playerList.add(playerId6!= null ? playerId6.intValue() : null);
        return playerList;
    }

    public SattaTeam getSattaTeam() {
        return team;
    }

    public void setSattaTeam(SattaTeam team) {
        this.team = team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Long getPlayerId1() {
        return playerId1;
    }

    public void setPlayerId1(Long playerId1) {
        this.playerId1 = playerId1;
    }

    public Long getPlayerId2() {
        return playerId2;
    }

    public void setPlayerId2(Long playerId2) {
        this.playerId2 = playerId2;
    }

    public Long getPlayerId3() {
        return playerId3;
    }

    public void setPlayerId3(Long playerId3) {
        this.playerId3 = playerId3;
    }

    public Long getPlayerId4() {
        return playerId4;
    }

    public void setPlayerId4(Long playerId4) {
        this.playerId4 = playerId4;
    }

    public Long getPlayerId5() {
        return playerId5;
    }

    public void setPlayerId5(Long playerId5) {
        this.playerId5 = playerId5;
    }

    public Long getPlayerId6() {
        return playerId6;
    }

    public void setPlayerId6(Long playerId6) {
        this.playerId6 = playerId6;
    }

    public List<Long> getPlayers(){
        return Arrays.asList(playerId1, playerId2, playerId3, playerId4, playerId5, playerId6);
    }


    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {

        private Pick pick;

        public Builder() {
            pick = new Pick();
        }

        public Builder user(Long userId) {
            pick.userId = userId;
            return this;
        }

        public Builder matchId(Long matchId){
            pick.matchId = matchId;
            return this;
        }

        public Builder team(SattaTeam sattaTeam1){
            pick.team = sattaTeam1;
            return this;

        }

        public Builder players(Long player1, Long player2, Long player3, Long player4, Long player5, Long player6 ) {
            pick.playerId1 = player1;
            pick.playerId2 = player2;
            pick.playerId3 = player3;
            pick.playerId4 = player4;
            pick.playerId5 = player5;
            pick.playerId6 = player6;
            return this;
        }

        public Pick build() {
            return pick;
        }
    }

}
