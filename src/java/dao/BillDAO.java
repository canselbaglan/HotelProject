/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Bill;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DBConnection;

/**
 *
 * @author Ali
 */
public class BillDAO {

    private Connection db;

    public void createBill(Bill bill) {
        try {
            Statement st = this.getDb().createStatement();
            String query = "INSERT INTO bill (customerid,date,total) VALUES('" + bill.getCustomerid() + "','" + bill.getDate() + "','" + bill.getTotal() + "')";
            int r = st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Bill> getAllBills() {
        List<Bill> bills = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();
            String query = "select * from bill";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                bills.add(new Bill(rs.getLong("id"), rs.getLong("customerid"), rs.getTimestamp("date"), rs.getFloat("total")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bills;
    }
    
    public Bill getBill(int customerID){
    Bill bill = null;
        try {
            Statement st = this.getDb().createStatement();
            String query = "select * from bill where customerid='"+customerID+"' limit 1";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                bill=new Bill(rs.getLong("id"), rs.getLong("customerid"), rs.getTimestamp("date"), rs.getFloat("total"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bill;
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
