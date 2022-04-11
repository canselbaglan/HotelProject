/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Users;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
  private Long id;
    private Long menuId;
    private String name;
    private String surname;
    private String password;
 */
public class UserDAO {
     private Connection db;
     
      public void createUser(Users user) {
        try {
            Statement st = this.getDb().createStatement();
            String query = "INSERT INTO user (menuId,name,surname,password) VALUES('" + user.getMenuId() + "','" + user.getName() + "','" + user.getSurname() + "','" + user.getPassword() + "')";
            int r = st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

   public Connection getDb() {
        if (this.db == null) {
            DBConnection dbc = new DBConnection();
            this.db = dbc.connect();
        }
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }
    
}
