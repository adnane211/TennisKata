package com.tenniskata.util;

/**
 * Game util class.
 * @author adnane
 */
public final class GameUtil {

    /**
     * Method to log score.
     * @param gameEvent the game event.
     * @param score the game score.
     * @return the log.
     */
    public static String logScore(final String gameEvent, final String score) {
        if (gameEvent != null && !gameEvent.isEmpty() && score != null && !score.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n********** ").append(gameEvent).append(" **********\n");
            sb.append(score).append("\n");
            sb.append("********************************************\n");
            return sb.toString();
        } else {
            return null;
        }
    }

}
