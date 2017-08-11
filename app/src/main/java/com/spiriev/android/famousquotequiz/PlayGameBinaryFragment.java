package com.spiriev.android.famousquotequiz;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Represents main game binary choice screen
 */

public class PlayGameBinaryFragment extends Fragment {
    TextView questionText;
    TextView hintText;
    Button yesButton;
    Button noButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View playGameBinary = inflater.inflate(R.layout.play_game_binary, container, false);
        if (!this.getArguments().isEmpty()) {
            Serializable testData = this.getArguments().getSerializable("MAP_DATA");
            HashMap<String, ArrayList<String>> testDataMap = (HashMap<String, ArrayList<String>>) testData;
            setAppropriateText(testDataMap, playGameBinary);
        }

        return playGameBinary;
    }

    /**
     * Sets the text in text views for a single question screen.
     *
     * @param testData  Map with data to be set in text views
     * @param container The top-level view
     */
    private void setAppropriateText(HashMap<String, ArrayList<String>> testData, View container) {

        questionText = (TextView) container.findViewById(R.id.game_text_view_binary);
        hintText = (TextView) container.findViewById(R.id.name_text);
        yesButton = (Button) container.findViewById(R.id.yes_option);
        noButton = (Button) container.findViewById(R.id.no_option);

        Iterator iterator = testData.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry questionPair = (Map.Entry) iterator.next();
            String question = (String) questionPair.getKey();
            questionText.setText(question);

            ArrayList<String> answers = (ArrayList<String>) questionPair.getValue();
            hintText.setText(answers.get(0));
        }
    }

}
