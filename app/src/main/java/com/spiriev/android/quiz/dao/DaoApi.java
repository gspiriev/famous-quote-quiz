package com.spiriev.android.quiz.dao;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Manages and loads data objects.
 */

public interface DaoApi {
    /**
     * Loads the game data - questions and answers.
     *
     * @return A map with questions as keys and answers as values
     */
    HashMap<String, ArrayList<String>> loadGameData();
}
