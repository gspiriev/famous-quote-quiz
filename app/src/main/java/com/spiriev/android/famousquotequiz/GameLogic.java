package com.spiriev.android.famousquotequiz;

import android.app.Fragment;
import android.app.FragmentManager;

import java.util.ArrayList;
import java.util.Map;

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
        Map<String, ArrayList<String>> gameTextData = dao.loadGameData();
        if (modeSelected == 0){
            baseActivity.fillBinaryFragmentText();

        }else if(modeSelected == 1) {
            baseActivity.fillMultipleChoiceFragmentText();
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
