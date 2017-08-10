package com.spiriev.android.famousquotequiz;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;


/**
 * Represents the Settings screen
 */

public class SettingsFragment extends Fragment {

    private Switch settingsSwitch = null;
    private OnDataPass dataPasser;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View gameSettingsView = inflater.inflate(R.layout.game_settings, container, false);
        settingsSwitch = (Switch) gameSettingsView.findViewById(R.id.settings_switch);
        settingsSwitch.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String switchState = b ? "SWITCH_ON" : "SWITCH_OFF";
                passData(switchState);
            }
        });
        return gameSettingsView;
    }

    /**
     * Also connects the dataPasser to the activity
     * which implements OnDataPass.
     * TODO: It's deprecated, but my fragment - activity
     * TODO: communication doesn't work with onAttach(Context ctx)
     *
     * @param activity Represents the containing activity
     */
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        dataPasser = (OnDataPass) activity;
    }

    /**
     * Interface for communication between Activities and Fragments
     */
    public interface OnDataPass {
        void onDataPassed(String data);
    }

    /**
     * Passes data to the activity which implements
     * OnDataPass
     *
     * @param data Data to be passed
     */
    public void passData(String data) {
        dataPasser.onDataPassed(data);
    }
}
