/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Customer;
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
 * @author CANSEL
 */
public class CustomerDAO {
    
    private Connection db;

    public void createCustomer(Customer customer) {
        try {
            Statement st = this.getDb().createStatement();
            String query = "INSERT INTO customer (name,surname,phonenumber,customerlogin,customerexit,RoomID) VALUES ('" + customer.getName() + "','" + customer.getSurname() + "','" + customer.getPhoneNumber() + "','" + customer.getCustomerLogin() + "','" + customer.getCustomerExit() + "','" + customer.getRoomID() + "')";
            int r = st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();
            
            String query = "select * from customer";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                customers.add(new Customer(rs.getLong("id"), rs.getString("name"), rs.getString("surname"), rs.getLong("phonenumber"),rs.getDate("customerlogin"),rs.getDate("customerexit"),rs.getLong("RoomID")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customers;
    }
 
public Customer getCustomer(int id) {
        Customer customer = null;
        try {
            Statement st = this.getDb().createStatement();
            String query = "select * from customer where id='" + id + "' limit 10";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                customer = new Customer(rs.getLong("id"), rs.getString("name"), rs.getString("surname"), rs.getLong("phonenumber"),rs.getDate("customerlogin"),rs.getDate("customerexit"),rs.getLong("RoomID"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return customer;
    }
   

    public Connection getDb() {
       if(this.db == null)  {
          //her seferinde bir nesnenin olduğundan emin olmak 
           DBConnection dbc = new DBConnection();
           this.db=dbc.connect();    
       }
           return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }

    public void updateCustomer(Customer entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void deleteCustomer(Long id) {
        try {
            String query = "DELETE FROM customer WHERE id = '" + "'";
            this.getDb().prepareStatement(query).executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

   
    
    
}
