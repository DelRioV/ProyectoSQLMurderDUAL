package org.login.app.model.mysql.manager.imp;

import javafx.scene.control.Alert;
import org.login.app.model.mysql.manager.QueryRecoverManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Stream;



public class QueryRecoverManagerImp implements QueryRecoverManager {

    private static final String[] WORDS = {"insert", "update", "drop", ";", "user", "user_code", "solution", "delete"};

    @Override
    public ArrayList<ArrayList<String>> executeQuery(Connection connection, String query, int user_code) {
        ArrayList<ArrayList<String>> recoverQuery = new ArrayList<>();
        String lowerQuery = query.toLowerCase();
        if (!confirmQuery(lowerQuery)) {
            try {
                query = convertQuery(query, user_code);
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query + ";");
                while (rs.next()) {
                    int index = 1;
                    ArrayList<String> addInfo = new ArrayList<>();
                    try {
                        while (true) {
                            addInfo.add(rs.getString(index));
                            index++;
                        }
                    } catch (Exception e) {
                        recoverQuery.add(addInfo);
                    }
                }
                return recoverQuery;
            } catch (SQLException e) {
                System.out.println("Something introduced isn't correct");
                return null;
            }
        } else {
            return null;
        }
    }

    private boolean confirmQuery(String query) {
        boolean condition = false;
        for (int i = 0; i < WORDS.length; i++) {
            if (query.contains(WORDS[i])) {
                condition = true;
                break;
            }
        }
        return condition;
    }

    private int getWhereCounter(String query) {
        String comparableWord = "where";
        int counter = 0;
        if (query.contains(comparableWord)) {
            for (int i = 0; i < query.length(); i++) {
                if (query.charAt(i) == comparableWord.charAt(0)) {
                    String compareQuery = "";
                    for (int x = 0; x < comparableWord.length(); x++) {
                        compareQuery += query.charAt(i++);
                    }
                    if (compareQuery.equalsIgnoreCase(comparableWord)) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public String convertQuery(String query, int user_code) {
        int counter = getWhereCounter(query);
        String updatedQuery = "";
        if (counter == 0) {
            updatedQuery += query + " where user_code = " + user_code;
        } else {
            String comparableWord = "where";
            for (int i = 0; i < query.length(); i++) {
                if (query.charAt(i) == comparableWord.charAt(0)) {
                    String compareQuery = "";
                    for (int x = 0; x < comparableWord.length(); x++) {
                        compareQuery += query.charAt(i++);
                    }
                    if (compareQuery.equalsIgnoreCase(comparableWord)) {
                        updatedQuery += "where user_code = " + user_code + " and ";

                    }

                } else {
                    updatedQuery += query.charAt(i);
                }
            }
        }
            System.out.println(updatedQuery);

        return updatedQuery;
    }
}

    /** while (counter!=-1){
     if(counter==0){
     updatedQuery+=query+" where user_code = "+user_code;
     counter=-1;
     }
     else if(counter==1){
     if(query.contains("(")){
     updatedQuery+=query+" and user_code = "+user_code + ")";
     }
     else{
     updatedQuery+=query+" and user_code = "+user_code;
     }
     counter=-1;
     }
     else {
     String compareWord="and";
     for(int i=0;i<query.length();i++){
     String kk ="";
     if(i+2 < query.length() && compareWord.equals("and")){
     for(int y=0;y<3;y++){
     kk+=Character.toString(query.charAt(i+y));
     }
     if(kk.equals(compareWord)){
     updatedQuery +=" and user_code = "+user_code+" "+query.charAt(i);
     }
     else {
     updatedQuery+=query.charAt(i);
     }
     }
     String aux = Character.toString(query.charAt(i));
     if(aux.equals("(")){
     System.out.println("Entro");
     counter=getWhereCounter(query.substring(query.indexOf("(")));
     query=query.substring(query.indexOf("(")+1,query.length()-2);
     System.out.println(counter);
     break;
     }

     }
     }
     else
     if(query.contains("(")){
     updatedQuery+=query+" and user_code = "+user_code + ")";
     }
     System.out.println(updatedQuery);
     } **/


