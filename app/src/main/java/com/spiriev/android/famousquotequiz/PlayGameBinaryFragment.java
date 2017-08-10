package com.spiriev.android.famousquotequiz;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Represents main game binary choice screen
 */

public class PlayGameBinaryFragment extends Fragment {
    TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        String testString = this.getArguments().getString("TEST");
        View playGameBinary = inflater.inflate(R.layout.play_game_binary, container, false);
        Log.d("Passed String", testString);
        tv = (TextView) playGameBinary.findViewById(R.id.game_text_view_binary);
        tv.setText(testString);
        return playGameBinary;
    }

}
