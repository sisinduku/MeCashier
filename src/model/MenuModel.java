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
    
    private String kodeMenu, namaMenu;
    private int harga, kategori;
    private ArrayList baris = new ArrayList();
    private ArrayList menu = new ArrayList();
    
    public ArrayList getMenuContent(){
        String sql = "SELECT * FROM tbl_menu";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet hasil = ps.executeQuery();
            while(hasil.next()){
                baris.add(hasil.getString("kode_menu"));
                baris.add(hasil.getString("nama"));
                baris.add(hasil.getString("kategori"));
                baris.add(hasil.getInt("kategori"));
                baris.add(hasil.getInt("harga"));
                menu.add(baris);
                baris.clear();
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
        return menu;
    }
}
