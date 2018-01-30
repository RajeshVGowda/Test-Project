package com.nineleafs.LearningRX.jdbcdemo;

import com.nineleafs.LearningRX.jdbc.ConnectionSubscription;
import com.nineleafs.LearningRX.util.DataGenerator;
import rx.Observable;

import java.sql.*;
import java.util.ArrayList;

public class MyJDBCDemo {


    public static void  init(){
        Connection conn=null;
        Statement statement=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Class loaded...");
            System.out.println("------------------");
            conn=createConnection();
            System.out.println("Connection Established successfully....");
            System.out.println("------------------");
            statement=conn.createStatement();
            System.out.println("Statement has created...");
            String createQuery="CREATE TABLE GREEKDEM( ID BIGINT, LETTER VARCHAR(20) )";
            statement.execute(createQuery);
            int id=1;
            for(String letter: DataGenerator.generateGreekAlphabet()){
                String insertQuery="Insert into GREEKDEM(ID,LETTER) values ("+(id++)+",\'"+letter+"\')";
                statement.execute(insertQuery);
            }
            System.out.println("Inserted data into Table ...");

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        finally {
            if(conn!=null){
                if(statement!=null){
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Connection createConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/Test","root","root");
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    public static Observable<String> selectAllLetter(ConnectionSubscription connSubscription){
        try {
            Statement s = connSubscription.getConnection().createStatement();
            connSubscription.registerResourceForClose(s);

            ResultSet rs = s.executeQuery("SELECT LETTER FROM GREEKDEM");
            connSubscription.registerResourceForClose(rs);

            ArrayList<String> returnList = new ArrayList<>();
            while( rs.next() ) {
                returnList.add( rs.getString( "LETTER" ) );
            }
            return Observable.from(returnList);
        }
        catch( SQLException e ) {
            throw new RuntimeException(e.getMessage(),e);
        }

    }
}
