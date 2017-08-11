package com.spiriev.android.famousquotequiz;

import com.spiriev.android.quiz.dao.DaoApi;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * An implementation of GameLogicAPI
 */

class GameLogic implements GameLogicAPI {

    private DaoApi dao;

    public GameLogic(DaoApi dao) {
        this.dao = dao;
    }

    @Override
    public void startGameSession(int modeSelected, BaseGameActivity baseActivity) {
        HashMap<String, ArrayList<String>> gameTextData = dao.loadGameData();
        if (modeSelected == 0) {
            baseActivity.createBinaryQuestionFragment(gameTextData);

        } else if (modeSelected == 1) {
            baseActivity.createMultipleChoiceQuestionFragment();
        }
    }

    @Override
    public void restartGameSession(int modeSelected) {
        dao.loadGameData();
    }

    @Override
    public void resumeGameSession() {

    }
}
