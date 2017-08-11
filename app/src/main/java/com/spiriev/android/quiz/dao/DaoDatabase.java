package com.spiriev.android.quiz.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Database implementation of DaoApi
 */

public class DaoDatabase implements DaoApi {

    private HashMap<String, ArrayList<String>> gameTextDataTest = new HashMap<>(10);
/*
    private final Connection conn;
    private final Parser parser;
    private final String queryColumns;
    private final String queryTable;

    public DaoDatabase(Connection conn, Parser parser, String queryColumns, String queryTable) {
        this.conn = conn;
        this.parser = parser;
        this.queryColumns = queryColumns;
        this.queryTable = queryTable;
    }

    public ArrayList<ArrayList<String>> loadAll() {

        ArrayList<ArrayList<String>> data = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT " + queryColumns + " FROM " + queryTable;
            String[] queryColumnsArray = queryColumns.split(",");
            ResultSet rs = stmt.executeQuery(sql);
            String dataString = "";
            while (rs.next()) {
                for (int i = 1; i <= queryColumnsArray.length; i++) {
                    if (i == queryColumnsArray.length) {
                        dataString += rs.getString(i);
                    } else {
                        dataString += (rs.getString(i) + "/");
                    }
                }
                ArrayList<String> dataPiece = parser.parse(dataString);
                data.add(dataPiece);
                dataString = "";
            }

        } catch (SQLException e) {
            System.err.println("Invalid SQL query");
            e.printStackTrace();
        }
        return data;
    }*/

    //TODO: Real SQLite implementation
    @Override
    public HashMap<String, ArrayList<String>> loadGameData() {
        ArrayList<String> answers = new ArrayList<>();
        ArrayList<String> moreAnswers = new ArrayList<>();
        answers.add("Oscar Wilde");

        for (int i = 0; i < 3; i++) {
            answers.add("George B. Shaw");
        }
        answers.add("hint_incorrect");
        answers.add("1");
        moreAnswers.add("Emmanuel Kant");
        for (int i = 0; i < 3; i++){
            moreAnswers.add("W.Shakespear");
        }
        moreAnswers.add("hint_correct");
        for (int i = 0; i < 5; i++) {
            gameTextDataTest.put("There is no sincerer love than the love of food.", answers);
            gameTextDataTest.put("Science is organized knowledge, wisdom is organized life",moreAnswers);
        }
        return gameTextDataTest;
    }


}
