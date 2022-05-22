package org.login.app.model.mysql.manager.imp;

import javafx.scene.control.Alert;
import org.login.app.model.mysql.manager.QueryRecoverManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.stream.Stream;



public class QueryRecoverManagerImp implements QueryRecoverManager {

    private static final String [] WORDS={"insert","update","drop",";" ,"user","user_code","solution","delete"} ;

    @Override
    public ArrayList<ArrayList<String>> executeQuery(Connection connection, String query,int user_code) {
        ArrayList<ArrayList<String>> recoverQuery = new ArrayList<>();
        String lowerQuery=query.toLowerCase();
        if(!confirmQuery(lowerQuery)) {
            try {
                query =convertQuery(query,user_code);
                System.out.println(query);
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
        }
        else{
            return null;
        }
    }

    private boolean confirmQuery(String query) {
        boolean condition=false;
        for(int i=0;i<WORDS.length;i++){
            System.out.println(WORDS[i]);
            if(query.contains(WORDS[i])){
                condition=true;
                break;
            }
        }
        return condition;
    }

    private int getWhereCounter(String query){
        String comparableWord = "where";
        int counter=0;
        if (query.contains(comparableWord)){
            for (int i=0;i<query.length();i++){
                if(query.charAt(i)==comparableWord.charAt(0)){
                    String compareQuery="";
                    System.out.println("w");
                    for (int x=0;x<comparableWord.length();x++){
                        compareQuery+=query.charAt(i++);
                    }
                    if (compareQuery.equalsIgnoreCase(comparableWord)){
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public String convertQuery(String query,int user_code){
        int counter =getWhereCounter(query);
        String updatedQuery="";
        if(counter==0){
            updatedQuery+=query+" where user_code = "+user_code;
        }
        else if(counter==1){
            updatedQuery+=query+" and user_code = "+user_code;
        }
        else if(counter>1){
            String compareWord="and";
            for(int i=0;i<query.length();i++){
                String kk = Character.toString(query.charAt(i));
                if(i+2 < query.length()){
                    kk+=Character.toString(query.charAt(i+1));
                    kk+=Character.toString(query.charAt(i+2));
                    System.out.println(kk);
                }
                if(kk.equals(compareWord)){
                    updatedQuery +=" and user_code = "+user_code;
                    System.out.println(updatedQuery +" hola ");
                    i=query.indexOf("where",i);
                    if(i==-1){
                        break;
                    }
                }
                else {
                    updatedQuery+=query.charAt(i);
                }
            }
        }
        System.out.println(updatedQuery);
        return updatedQuery;
    }

}
