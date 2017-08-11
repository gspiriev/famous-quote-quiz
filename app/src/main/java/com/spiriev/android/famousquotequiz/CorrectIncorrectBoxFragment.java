package com.spiriev.android.famousquotequiz;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by h3moglob1n on 8/11/17.
 */

public class CorrectIncorrectBoxFragment extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View boxFragmentView = inflater.inflate(R.layout.correct_incorrect_dialog, container, false);
        String answerMessage = getArguments().getString("ANSWER_MESSAGE");
        TextView boxFragmentTextView = (TextView) boxFragmentView.findViewById(R.id.dialog_text_view);
        boxFragmentTextView.setText(answerMessage);
        Button button = (Button) boxFragmentView.findViewById(R.id.ok_dialog_button);
        button.setBackgroundColor(Color.DKGRAY);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                if(fragmentManager.getBackStackEntryCount() > 0){
                    fragmentManager.popBackStack();
                }
            }
        });

        return boxFragmentView;
    }


}
