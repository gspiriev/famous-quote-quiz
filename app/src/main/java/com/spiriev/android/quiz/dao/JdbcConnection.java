package com.spiriev.android.quiz.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by h3moglob1n on 8/11/17.
 */

public class JdbcConnection {
    private Connection conn;

    //private final DaoDatabase questionsDao;

    public JdbcConnection(Properties props, InputStream databaseStream) {

        try {
            Class.forName(props.getProperty("driverName"));
            String databaseFile = this.getClass().getClassLoader().getResource(props.getProperty("dbName")).getFile();
            //databaseStream.
            this.conn = DriverManager.getConnection(props.getProperty("connAndEngine") + databaseFile);

            conn.setAutoCommit(false);

            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.err.println("Database file may not be present: " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("Jdbc driver not found");
        }
        String questionsQueryColumns = "question.question_id,question.question_text, answer.answer_text, answer.right_answer";
        String questionsQueryTable = "question JOIN answers ON question.question_id=answer.to_question";

        //this.questionsDao = new DaoDatabase(conn, new QuestionsParser(), questionsQueryColumns, questionsQueryTable);

    }

    public void commitTransaction() {

        try {
            if(this.conn != null) {
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch(SQLException e) {
            System.err.println("Invalid operation or missing database file: " + e);
        }

    }

    /*public DaoDatabase getQuestionsDao(){
        return questionsDao;
    }*/
}
