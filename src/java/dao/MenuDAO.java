/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Menu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Ali
 */
public class MenuDAO {

    private Connection db;

    public void createMenu(Menu menu) {
        try {
            Statement st = this.getDb().createStatement();
            String query = "INSERT INTO menu (food,drink,desserts) values('" + menu.getFood() + "','" + menu.getDrink() + "','" + menu.getDesserts() + "')";
            int r = st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Menu> getAllMenus() {
        List<Menu> menus = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();
            String query = "select * from menu";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                menus.add(new Menu(rs.getLong("id"), rs.getString("food"), rs.getString("drink"), rs.getString("desserts")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return menus;
    }

    public Menu getMenu(int id) {
        Menu menu = null;
        try {
            Statement st = this.getDb().createStatement();
            String query = "select * from menu where id='" + id + "' limit 1";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                menu = new Menu(rs.getLong("id"), rs.getString("food"), rs.getString("drink"), rs.getString("desserts"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return menu;
    }

    public void updateMenu(Menu menu) {
        try {
            String query = "UPDATE menu SET food='" + menu.getFood() + "', drink='" + menu.getDrink() + "', desserts='" + menu.getDesserts() + "' WHERE id='" + menu.getId() + "'";
            this.getDb().prepareStatement(query).executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteMenu(Long id) {
        try {
            String query = "DELETE FROM menu WHERE id = '" + id + "'";
            this.getDb().prepareStatement(query).executeUpdate();
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
