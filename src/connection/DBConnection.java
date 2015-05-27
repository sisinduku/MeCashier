/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Programmer : @author Soliloquy
 * Nama File : 
 * Deskripsi :
 */
public class DBConnection {
    private Connection DBConnection;
    public Connection connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connection Success");
        }catch(ClassNotFoundException cnfe){
            System.out.println("Connection fail "+ cnfe);
        }
        String url = "jdbc:mysql://localhost:3306/db_mecashier";
        try{
            DBConnection = (Connection)DriverManager.getConnection(url, "root", "");
            System.out.println("Database Connected");
        }catch(SQLException se){
            System.out.println("No Database "+ se);
        }
        return DBConnection;
    }
}
