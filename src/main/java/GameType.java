/**
 * This enumeration will show different game type options, this could be added to.
 */
public enum GameType {
    /**
     * FullGame
     * In the full game there is no time limit. A winner is determined by whoever is the last player with funds.
     */
    FullGame,

    /**
     * AbridgedGame
     * In the abridged game there is a time limit defined in the UI. At the end of the time the winner is the player with the most assets.
     */
    AbridgedGame
}
