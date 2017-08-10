package com.spiriev.android.famousquotequiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Database implementation of DaoApi
 */

class DaoDatabase implements DaoApi {

    private Map<String, ArrayList<String>> gameTextDataTest = new HashMap<>(10);
    //TODO: Real SQLite implementation, Right answer index should be 4.
    @Override
    public Map<String, ArrayList<String>> loadGameData() {
        ArrayList<String> answers = new ArrayList<>();
        answers.add("Yaser Arafat?");

        for(int i = 0;i < 3; i++){
            answers.add("Jumbo");
            i++;
        }
        answers.add("1");
        for(int i = 0;i < 10; i++) {
            gameTextDataTest.put("Who is it Who is it Who is it Who is it Who is it?", answers);
        }
        return  gameTextDataTest;
    }
}
