package com.tenniskata.tennisGame;

import com.tenniskata.player.TennisPlayer;

/**
 * POJO Tennis game.
 * @author adnane
 */
public class TennisGame {

    /**
     * Player One.
     */
    private TennisPlayer playerOne;
    /**
     * Player Two.
     */
    private TennisPlayer playerTwo;

    /**
     * Constructor.
     *
     * @param tennisPlayerOne First tennis player.
     * @param tennisPlayerTwo Second tennis player.
     */
    public TennisGame(TennisPlayer tennisPlayerOne, TennisPlayer tennisPlayerTwo) {
        this.playerOne = tennisPlayerOne;
        this.playerTwo = tennisPlayerTwo;
    }

    /**
     * Method to display the game score.
     *
     * @return game score.
     */
    public String displayGameScore() {
        if ((playerOne.getScore() == 0) && (playerTwo.getScore() == 0)) {
            return playerOne.getName() + ":" + transcodeScore(playerOne.getScore()) + " - " + playerTwo.getName() + ":" + transcodeScore(playerTwo.getScore());
        } else if ((playerOne.getScore() > 3) && (playerTwo.getScore() < 3) && (playerOne.getScore() - playerTwo.getScore() > 1)) {
            return "Game " + playerOne.getName();
        } else if ((playerTwo.getScore() > 3) && (playerOne.getScore() < 3) && (playerTwo.getScore() - playerOne.getScore() > 1)) {
            return "Game " + playerTwo.getName();
        } else if (playerOne.getScore() == 3 && playerTwo.getScore() == 3) {
            return "Deuce";
        } else {
            return playerOne.getName() + ":" + transcodeScore(playerOne.getScore()) + " - " + playerTwo.getName() + ":" + transcodeScore(playerTwo.getScore());
        }
    }

    /**
     * Method to manage tie break.
     *
     * @param playerOne
     * @param playerTwo
     * @return
     */
    public String tieBreak(TennisPlayer playerOne, TennisPlayer playerTwo) {
        if (playerOne.getScore() == 4 && playerTwo.getScore() < 4) {
            return transcodeScore(playerOne.getScore()) + " " + playerOne.getName();
        } else if (playerTwo.getScore() == 4 && playerOne.getScore()<4) {
            return transcodeScore(playerTwo.getScore()) + " " + playerTwo.getName();
        } else if (playerOne.getScore() == 4 && playerTwo.getScore() == 4) {
            playerOne.setScore(playerOne.getScore() - 1);
            playerTwo.setScore(playerTwo.getScore() - 1);
            return "Deuce";
        } else if (playerOne.getScore() > 4 && (playerOne.getScore() - playerTwo.getScore() == 2)) {
            return "Set " + playerOne.getName();
        } else if (playerTwo.getScore() > 4 && (playerTwo.getScore() - playerOne.getScore() == 2)) {
            return "Set " + playerTwo.getName();
        }
        return null;
    }

    /**
     * Method to transcode the player's score into Tennis score.
     *
     * @param playerScore Player score.
     * @return Tennis score.
     */
    public String transcodeScore(final int playerScore) {
        switch (playerScore) {
            case 0:
                return "0";
            case 1:
                return "15";
            case 2:
                return "30";
            case 3:
                return "40";
            case 4:
                return "Advantage";
            default:
                return String.valueOf(playerScore);
        }
    }

}
