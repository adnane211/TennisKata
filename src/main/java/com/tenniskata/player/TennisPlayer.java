package com.tenniskata.player;

/**
 * POJO Tennis player.
 * @author adnane
 */
public class TennisPlayer {

    private String name;
    private int score;

    public TennisPlayer(String name) {
        this.name = name;
    }

    /**
     * Getter of tennis player's name.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter of player's name.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter of player's score.
     *
     * @return
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Setter of player's score.
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Score one ball.
     * @return 
     */
    public int scoreBall() {
        return this.score = this.score + 1;
    }

}
