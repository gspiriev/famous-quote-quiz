package com.spiriev.android.famousquotequiz;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Represents main game binary choice screen
 */

public class PlayGameBinaryFragment extends Fragment implements View.OnClickListener {
    TextView questionText;
    TextView hintText;
    Button yesButton;
    Button noButton;
    ArrayList<String> answerList = null;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View playGameBinary = inflater.inflate(R.layout.play_game_binary, container, false);
        yesButton = (Button) playGameBinary.findViewById(R.id.yes_option);
        noButton = (Button) playGameBinary.findViewById(R.id.no_option);
        questionText = (TextView) playGameBinary.findViewById(R.id.game_text_view_binary);
        hintText = (TextView) playGameBinary.findViewById(R.id.name_text);

        yesButton.setOnClickListener(this);
        noButton.setOnClickListener(this);

        if (!this.getArguments().isEmpty()) {
            String questionString = (String) getArguments().get("QUESTION");
            answerList = (ArrayList<String>) getArguments().get("ANSWER_LIST");
            setAppropriateText(questionString, answerList);
        }

        return playGameBinary;
    }

    /**
     * Sets the text in text views for a single question screen.
     *
     * @param question A string containing the question
     * @param answers  An ArrayList containing the answers
     */
    private void setAppropriateText(String question, ArrayList<String> answers) {
        questionText.setText(question);
        hintText.setText(answers.get(0) + "?");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.yes_option:
                yesOptionAction();
                break;
            case R.id.no_option:
                noOptionAction();
                break;
        }
    }

    /**
     * Shows the Correct/Incorrect dialog box
     */
    private void yesOptionAction() {


        CorrectIncorrectBoxFragment correctIncorrectBoxFragment =
                new CorrectIncorrectBoxFragment();
        Bundle bundle = new Bundle();
        Integer correctAnswerIndex = Integer.parseInt(answerList.get(5));
        if (answerList.get(4).equals("hint_correct")) {
            String message = "Correct! The right answer is..." + answerList.get(correctAnswerIndex);
            bundle.putString("ANSWER_MESSAGE", message);
        } else {
            String message = "Sorry, you are wrong! The right answer is..." + answerList.get(correctAnswerIndex);
            bundle.putString("ANSWER_MESSAGE", message);
        }
        correctIncorrectBoxFragment.setArguments(bundle);
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.binary_game_layout, correctIncorrectBoxFragment)
                .addToBackStack(null).commit();

    }

    /**
     * Shows the Correct/Incorrect dialog box
     */
    private void noOptionAction() {


        CorrectIncorrectBoxFragment correctIncorrectBoxFragment =
                new CorrectIncorrectBoxFragment();
        Bundle bundle = new Bundle();
        Integer correctAnswerIndex = Integer.parseInt(answerList.get(5));
        if (answerList.get(4).equals("hint_incorrect")) {
            String message = "Correct! The right answer is..." + answerList.get(correctAnswerIndex);
            bundle.putString("ANSWER_MESSAGE", message);
        } else {
            String message = "Sorry, you are wrong! The right answer is..." + answerList.get(correctAnswerIndex);
            bundle.putString("ANSWER_MESSAGE", message);
        }
        correctIncorrectBoxFragment.setArguments(bundle);
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.binary_game_layout, correctIncorrectBoxFragment)
                .addToBackStack(null).commit();
    }
}
