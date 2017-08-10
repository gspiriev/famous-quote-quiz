package com.spiriev.android.famousquotequiz;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Represents main game multiple choice screen
 */

public class PlayGameMultipleChoiceFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.play_game_multiple_choice,container,false);
    }
}
