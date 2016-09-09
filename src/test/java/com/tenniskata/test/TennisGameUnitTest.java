package com.tenniskata.test;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.tenniskata.player.TennisPlayer;
import com.tenniskata.tennisGame.TennisGame;
import com.tenniskata.util.GameUtil;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * Test class tennis game.
 *
 * @author adnane
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TennisGameUnitTest {

    /**
     * The first tennis player.
     */
    private static TennisPlayer playerOne;
    /**
     * The second tennis player.
     */
    private static TennisPlayer playerTwo;
    /**
     * The tennis game.
     */
    private static TennisGame tennisGame;

    /**
     * Constructor.
     */
    public TennisGameUnitTest() {
    }

    /**
     * SetUp.
     */
    @Before
    public void setUp() {
        playerOne = new TennisPlayer("Roger FEDERER");
        playerTwo = new TennisPlayer("Novak djokovic");
        tennisGame = new TennisGame(playerOne, playerTwo);
    }

    /**
     * Test game starting.
     */
    @Test
    public void testAGameStartsWithZeroEach() {
        assertEquals("Roger FEDERER:0 - Novak djokovic:0", tennisGame.displayGameScore());
        Logger.getLogger(TennisGameUnitTest.class.getName()).log(Level.INFO, GameUtil.logScore("GameStartsWithZeroEach", "Roger FEDERER:0 - Novak djokovic:0"));

    }

    /**
     * Test Federer scoring first ball.
     */
    @Test
    public void testBPlayerOneScoresOneBall() {
        IntStream.range(0, 1).forEach(i -> playerOne.scoreBall());
        assertEquals(1, playerOne.getScore());
        assertEquals("Roger FEDERER:15 - Novak djokovic:0", tennisGame.displayGameScore());
        Logger.getLogger(TennisGameUnitTest.class.getName()).log(Level.INFO, GameUtil.logScore("PlayerOneScoresOneBall", "Roger FEDERER:15 - Novak djokovic:0"));

    }

    /**
     * Test Djokovic scoring first ball.
     */
    @Test
    public void testCPlayerTwoScoresOneBall() {
        IntStream.range(0, 1).forEach(i -> playerOne.scoreBall());
        assertEquals(1, playerOne.getScore());
        IntStream.range(0, 1).forEach(i -> playerTwo.scoreBall());
        assertEquals(1, playerTwo.getScore());
        assertEquals("Roger FEDERER:15 - Novak djokovic:15", tennisGame.displayGameScore());
        Logger.getLogger(TennisGameUnitTest.class.getName()).log(Level.INFO, GameUtil.logScore("PlayerTwoScoresOneBall", "Roger FEDERER:15 - Novak djokovic:15"));

    }

    /**
     * Test federer scoring the second ball.
     */
    @Test
    public void testDPlayerOneScoresTwoBalls() {
        IntStream.rangeClosed(0, 1).forEach(i -> playerOne.scoreBall());
        assertEquals(2, playerOne.getScore());
        IntStream.range(0, 1).forEach(i -> playerTwo.scoreBall());
        assertEquals(1, playerTwo.getScore());
        assertEquals("Roger FEDERER:30 - Novak djokovic:15", tennisGame.displayGameScore());
        Logger.getLogger(TennisGameUnitTest.class.getName()).log(Level.INFO, GameUtil.logScore("PlayerOneScoresTwoBalls", "Roger FEDERER:30 - Novak djokovic:15"));

    }

    /**
     * Test Djokovic scoring two balls.
     */
    @Test
    public void testFPlayerTwoScoresTwoBalls() {

        IntStream.rangeClosed(0, 1).forEach(i -> playerOne.scoreBall());
        assertEquals(2, playerOne.getScore());
        IntStream.rangeClosed(0, 1).forEach(i -> playerTwo.scoreBall());
        assertEquals(2, playerTwo.getScore());
        assertEquals("Roger FEDERER:30 - Novak djokovic:30", tennisGame.displayGameScore());
        Logger.getLogger(TennisGameUnitTest.class.getName()).log(Level.INFO, GameUtil.logScore("PlayerTwoScoresTwoBalls", "Roger FEDERER:30 - Novak djokovic:30"));

    }

    /**
     * Test Federer scoring third ball.
     */
    @Test
    public void testGPlayerOneScoresThreeBalls() {

        IntStream.rangeClosed(0, 2).forEach(i -> playerOne.scoreBall());
        assertEquals(3, playerOne.getScore());
        IntStream.rangeClosed(0, 1).forEach(i -> playerTwo.scoreBall());
        assertEquals(2, playerTwo.getScore());
        assertEquals("Roger FEDERER:40 - Novak djokovic:30", tennisGame.displayGameScore());
        Logger.getLogger(TennisGameUnitTest.class.getName()).log(Level.INFO, GameUtil.logScore("PlayerOneScoresThreeBalls", "Roger FEDERER:40 - Novak djokovic:30"));

    }

    /**
     * Test Deuce.
     */
    @Test
    public void testHDeuce() {
        IntStream.rangeClosed(0, 2).forEach(i -> playerOne.scoreBall());
        IntStream.rangeClosed(0, 2).forEach(i -> playerTwo.scoreBall());
        assertEquals("Deuce", tennisGame.displayGameScore());
        Logger.getLogger(TennisGameUnitTest.class.getName()).log(Level.INFO, GameUtil.logScore("Deuce", "Deuce"));

    }

    /**
     * Test TieBreak.
     */
    @Test
    public void testITieBreak() {
        Logger.getLogger(TennisGameUnitTest.class.getName()).log(Level.INFO, "**************************** Begin Tie-Break ******************************");
        IntStream.rangeClosed(0, 2).forEach(i -> playerOne.scoreBall());
        IntStream.rangeClosed(0, 2).forEach(i -> playerTwo.scoreBall());
        playerOne.scoreBall();
        assertEquals("Advantage Roger FEDERER", tennisGame.tieBreak(playerOne, playerTwo));
        /**
         * Log set federer.
         */
        Logger.getLogger(TennisGameUnitTest.class.getName()).log(Level.INFO, GameUtil.logScore("Tie-Break", "Advantage Roger FEDERER"));
        playerTwo.scoreBall();
        assertEquals("Deuce", tennisGame.tieBreak(playerOne, playerTwo));
        /**
         * Log set federer.
         */
        Logger.getLogger(TennisGameUnitTest.class.getName()).log(Level.INFO, GameUtil.logScore("Deuce", "Deuce"));

        playerOne.scoreBall();
        playerOne.scoreBall();
        assertEquals("Set Roger FEDERER", tennisGame.tieBreak(playerOne, playerTwo));
        /**
         * Log set federer.
         */
        Logger.getLogger(TennisGameUnitTest.class.getName()).log(Level.INFO, GameUtil.logScore("Set", "Advantage Roger FEDERER"));

        Logger.getLogger(TennisGameUnitTest.class.getName()).log(Level.INFO, "**************************** End Tie-Break ******************************");

    }

    /**
     * Test game player one (Federer).
     */
    @Test
    public void testJGamePlayerOne() {
        IntStream.rangeClosed(0, 4).forEach(i -> playerOne.scoreBall());
        assertEquals(5, playerOne.getScore());
        IntStream.rangeClosed(0, 1).forEach(i -> playerTwo.scoreBall());
        assertEquals(2, playerTwo.getScore());
        assertEquals("Game Roger FEDERER", tennisGame.displayGameScore());
        Logger.getLogger(TennisGameUnitTest.class.getName()).log(Level.INFO, GameUtil.logScore("GamePlayerOne", "Game Roger FEDERER"));

    }

    /**
     * Test perfect game federer/djokovic.
     */
    @Test
    public void testKPlayerPerfectGame() {
        IntStream.rangeClosed(0, 3).forEach(i -> playerOne.scoreBall());
        assertEquals("Game Roger FEDERER", tennisGame.displayGameScore());
        Logger.getLogger(TennisGameUnitTest.class.getName()).log(Level.INFO, GameUtil.logScore("PlayerOnePerfectGame", "Game Roger FEDERER"));
        playerOne.setScore(0);
        IntStream.rangeClosed(0, 3).forEach((int i) -> playerTwo.scoreBall());
        assertEquals("Game Novak djokovic", tennisGame.displayGameScore());
        Logger.getLogger(TennisGameUnitTest.class.getName()).log(Level.INFO, GameUtil.logScore("PlayerTwoPerfectGame", "Game Novak djokovic"));
    }

}
