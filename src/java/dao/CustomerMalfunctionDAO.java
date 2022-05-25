/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author CANSEL
 */

import entity.CustomerMalfunction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;


public class CustomerMalfunctionDAO {
 
    private Connection db;
    
    public void createCustomerMalfunction(CustomerMalfunction customermalfunction) {
        try {
            Statement st = this.getDb().createStatement();
            String query = "INSERT INTO customermalfunction (malfunctionid,customerid) values('" + customermalfunction.getMalfunctionId() + "','" + customermalfunction.getCustomerId() +  "')";
            int r = st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<CustomerMalfunction> getAllCustomerMalfunctions() {
        List<CustomerMalfunction> customermalfunctions = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();
            String query = "select * from customermalfunction";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                customermalfunctions.add(new CustomerMalfunction(rs.getLong("malfunctionid"),rs.getLong("customerid")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customermalfunctions;
    }

    public CustomerMalfunction getCustomerMalfunctions(int id) {
        CustomerMalfunction customermalfunction = null;
        try {
            Statement st = this.getDb().createStatement();
            String query = "select * from customermalfunction where id='" + id + "' limit 1";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                customermalfunction = new CustomerMalfunction(rs.getLong("malfunctionid"),rs.getLong("customerid"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customermalfunction;
    }

    public void updateCustomerMalfunction(CustomerMalfunction customermalfunction) {
        try {
            String query = "UPDATE customermalfunction SET malfunctionid='" + customermalfunction.getMalfunctionId() + "', customerid='" + customermalfunction.getCustomerId()  + "' WHERE id='" + customermalfunction.getId() + "'";
            this.getDb().prepareStatement(query).executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteCustomerMalfunction(Long id) {
        try {
            String query = "DELETE FROM customermalfunction WHERE id = '" + id + "'";
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

    

