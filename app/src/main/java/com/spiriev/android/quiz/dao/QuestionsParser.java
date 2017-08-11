package com.spiriev.android.quiz.dao;

import java.util.ArrayList;

/**
 * Created by h3moglob1n on 8/11/17.
 */

public class QuestionsParser implements Parser {

    @Override
    public ArrayList<String> parse(String stringToParse) {
        ArrayList<String> questionAnswer = null;
        String[] stringToParseArray = stringToParse.split("/");
        String id = stringToParseArray[0];
        String questionText = stringToParseArray[1];
        String answerText = stringToParseArray[2];
        String rightAnswer = stringToParseArray[3];
        questionAnswer.add(id);
        questionAnswer.add(questionText);
        questionAnswer.add(answerText);
        questionAnswer.add(rightAnswer);
        return questionAnswer;
    }
}
