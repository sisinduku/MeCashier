/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import view.AdminMenu;

/**
 * Programmer : @author Soliloquy
 * Nama File : 
 * Deskripsi :
 */
public class AdminModel {
    Connection conn = new DBConnection().connect();
    private String username, password;
    private int privilege;
    
    public AdminModel(){
    
    }
    
    public AdminModel(String username, String password, int privilege){
        this.username = username;
        this.password = password;
        this.privilege = privilege;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public int getPrivilege(){
        return this.privilege;
    }
    
    public boolean getAdminModelbyUsername(String username){
        String sql = "SELECT * FROM tbl_admin WHERE username=?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                this.username = rs.getString("username");
                this.password = rs.getString("password");
                this.privilege = rs.getInt("privilege");
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
}
