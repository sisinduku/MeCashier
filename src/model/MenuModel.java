/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import connection.DBConnection;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Programmer : @author Soliloquy
 * Nama File : 
 * Deskripsi :
 */
public class MenuModel {
    Connection conn = new DBConnection().connect();
    
    private String kodeMenu, namaMenu, keterangan;
    private int harga;
    private ArrayList menu = new ArrayList();
    
    public ArrayList getMenuContent(){
        String sql = "SELECT * FROM tbl_menu";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet hasil = ps.executeQuery();
            while(hasil.next()){
                Object[] o;
                o = new Object[4];
                o[0] = (hasil.getString("kodeMenu"));
                o[1] = (hasil.getString("namaMenu"));
                o[2] =( hasil.getString("keterangan"));
                o[3] = (hasil.getInt("harga"));
                menu.add(o);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return menu;
    }
    
    public String insertMenu(String kodeMenu, String namaMenu, String keterangan, int harga){
        String sql = "INSERT INTO tbl_menu (kodeMenu, namaMenu, keterangan, harga) VALUES (?, ?, ?, ?)";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kodeMenu);
            ps.setString(2, namaMenu);
            ps.setString(3, keterangan);
            ps.setInt(4, harga);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
            return "gagal";
        }
        return "sukses";
    }
    
    public String updateMenu(String kodeMenu, String namaMenu, String keterangan, int harga){
        String sql = "UPDATE tbl_menu SET kodeMenu = ?, namaMenu = ?, keterangan = ?, harga = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kodeMenu);
            ps.setString(2, namaMenu);
            ps.setString(3, keterangan);
            ps.setInt(4, harga);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
            return "gagal";
        }
        return "sukses";
    }
    
    public String deleteMenu(String kodeMenu){
        String sql = "DELETE FROM tbl_menu WHERE kodeMenu = ?";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kodeMenu);
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
            return "gagal";
        }
        return "sukses";
    }
}
