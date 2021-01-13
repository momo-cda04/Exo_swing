package com.company;

import java.sql.*;
import java.util.ArrayList;

public class Connect {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.sql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/exo_swing";

    //  Database credentials
    static final String USER = "root";
    public ArrayList<DataAuthentification> getAllUsersinDB() {
        Connection conn = null;
        Statement stmt = null;
        ArrayList<DataAuthentification> allUser = new ArrayList<DataAuthentification>();
        try{
            //STEP 2: Register JDBC driver
            //Class.forName("com.sql.jdbc.Driver");

            //STEP 3: Open a connection

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,"");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM user";
            ResultSet rs = stmt.executeQuery(sql);



            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String valeurUser  = rs.getString("user_login");
                String valeurPwd = rs.getString("user_password");
                allUser.add(new DataAuthentification(valeurUser,valeurPwd));

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();

        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return allUser;
    }//end main


    }
//end FirstExample






