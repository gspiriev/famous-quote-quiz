package com.spiriev.android.famousquotequiz;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;

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

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //changeFragment(0);
        fillBinaryFragmentText();
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
    //TODO: Javadoc
    void fillBinaryFragmentText() {
        Bundle bundle = new Bundle();
        bundle.putString("TEST", "TEST_VALUE");
        playGameBinary.setArguments(bundle);
        mFragmentManager.beginTransaction().replace(R.id.fragment_container,playGameBinary).commit();
    }

    void fillMultipleChoiceFragmentText() {
        PlayGameMultipleChoiceFragment playGameMultipleChoiceFragmentImpl =
                (PlayGameMultipleChoiceFragment)playGameMultipleChoice;
        //playGameMultipleChoiceFragmentImpl.updateTextViews();
    }
}
