/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.groupb.led34b.dao;

import com.groupb.led34b.database.MySqlConnection;
import com.groupb.led34b.model.RegisterModel;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author digitech
 */
public class AuthDAO extends MySqlConnection {
    public boolean register(RegisterModel registerModel){
        try{
            PreparedStatement ps = null;
            Connection conn = openConnection();
            
            String sql = "INSERT INTO users(username, password, email) VALUES(?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, registerModel.getUsername());
            ps.setString(2, registerModel.getPassword());
            ps.setString(3, registerModel.getEmail());
            
            int result = ps.executeUpdate();
            // Use executeUpdate for query that has Create, Update or Delete
            if(result == -1){
                return false;
            }else{
                return true;
            }
//            String sql = "INSERT INTO users(username, password, email) VALUES('test', 'test123', 'test@test.com')";
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
//        return false;
    }
}
