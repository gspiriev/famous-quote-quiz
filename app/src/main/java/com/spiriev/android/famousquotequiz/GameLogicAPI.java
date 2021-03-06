package com.spiriev.android.famousquotequiz;

/**
 * Interface which defines the gameplay functionality
 */

public interface GameLogicAPI {
    /**
     * Starts the game in the selected mode
     *
     * @param modeSelected Selected mode
     */
    void startGameSession(int modeSelected, BaseGameActivity baseActivity);

    /**
     * Restarts the game in the selected mode
     *
     * @param modeSelected Selected mode
     */
    void restartGameSession(int modeSelected);

    /**
     * Resume session if the same profile is used
     */
    void resumeGameSession();
}
