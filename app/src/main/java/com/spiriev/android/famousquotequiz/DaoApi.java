package com.spiriev.android.famousquotequiz;

import java.util.ArrayList;
import java.util.Map;

/**
 * Manages and loads data objects.
 */

public interface DaoApi {
    /**
     * Loads the game data - questions and answers.
     * @return A map with questions as keys and answers as values
     */
    Map<String, ArrayList<String>> loadGameData();
}
