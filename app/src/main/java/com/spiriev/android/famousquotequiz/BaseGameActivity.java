package com.spiriev.android.famousquotequiz;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;

import com.spiriev.android.quiz.dao.DaoDatabase;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * This is the main activity of the game. Contains fragments which represent
 * Play Game, Settings and Profile screens.
 */
public class BaseGameActivity extends Activity implements SettingsFragment.OnDataPass {

    private final FragmentManager mFragmentManager = getFragmentManager();
    private final Fragment settingsFragment = new SettingsFragment();
    private final Fragment playGameMultipleChoice = new PlayGameMultipleChoiceFragment();
    private final Fragment profileFragment = new ProfileFragment();
    private final Fragment playGameBinary = new PlayGameBinaryFragment();
    private boolean settingsSwitchOn;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_game:
                    changeFragment(0);
                    return true;
                case R.id.navigation_settings:
                    changeFragment(1);
                    return true;
                case R.id.navigation_profile:
                    changeFragment(2);
                    return true;
            }

            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_game_activity);
        hideStatusBar();

        Properties props = new Properties();
        try {
            InputStream inputStream = null;
            String propFileName = "game.properties";
            inputStream = getBaseContext().getAssets().open(propFileName);

            if (inputStream != null) {
                props.load(inputStream);
            } else {
                throw new FileNotFoundException("Properties file " + propFileName + "is not on the classpath");
            }
            inputStream.close();
        } catch (IOException e) {
            System.err.println("Exception: " + e);
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        DaoDatabase dao = new DaoDatabase();
        GameLogic gameLogic = new GameLogic(dao);
        gameLogic.startGameSession(0,this);
        //TODO: Database connectivity under development. Now it's wrong AND ugly.
        /*JdbcConnection conn = new JdbcConnection(props,databaseStream);
        DaoDatabase daoDatabase = conn.getQuestionsDao();
        ArrayList<ArrayList<String>> rawData = daoDatabase.loadAll();
        for (ArrayList<String> wrapper: rawData) {
            for (String data : wrapper) {
                Log.d("DATA_TEST: ", data);
            }
        }*/
    }

    /**
     * Hides status bar
     */
    private void hideStatusBar() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @Override
    public void onDataPassed(String data) {
        if (data.equals("SWITCH_ON")) {
            settingsSwitchOn = true;
        } else {
            settingsSwitchOn = false;
        }
    }

    /**
     * Instantiates custom fragment objects and changes to
     * a specified by position fragment.
     *
     * @param position The selected menu item index
     */
    private void changeFragment(int position) {
        Fragment newFragment = null;

        if (position == 0 && !settingsSwitchOn) {
            newFragment = playGameBinary;
        } else if (position == 0 && settingsSwitchOn) {
            newFragment = playGameMultipleChoice;
        } else if (position == 1) {
            newFragment = settingsFragment;
        } else if (position == 2) {
            newFragment = profileFragment;
        }

        mFragmentManager.beginTransaction().replace(R.id.fragment_container, newFragment).commit();

    }

    /**
     * Replaces a binary question fragment with a new one with a new
     * question.
     */
    void createBinaryQuestionFragment(HashMap<String, ArrayList<String>> data) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("MAP_DATA", data);
        playGameBinary.setArguments(bundle);
        mFragmentManager.beginTransaction().replace(R.id.fragment_container, playGameBinary).commit();
    }

    /**
     * Replaces a multiple choice question fragment with a new one with a new
     * question.
     */
    void createMultipleChoiceQuestionFragment() {

    }
}
