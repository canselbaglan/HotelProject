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
import java.util.Date;
/**
 *
 * @author CANSEL
 */
public class CustomerDAO {
    
    private Connection db;

    public void createCustomer(Customer customer) { //oluşturma
        try {
            Statement st = this.getDb().createStatement();
            String query = "INSERT INTO customer (name,surname,phonenumber,customerlogin,customerexit,roomid) values ('" + customer.getName() + "','" + customer.getSurname() + "','" + customer.getPhonenumber() + "','" + customer.getCustomerlogin() + "','" + customer.getCustomerexit() + "','" + customer.getRoomid() + "')";
            int r = st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Customer> getAllCustomers() { //List olarak return eden metod // ccutomer listesi çekme
        List<Customer> customers = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();
            
            String query = "select * from customer";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) { //çağırana istediği bilgiyi dönüş yapıyor yazdırma yok
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
   

    public void updateCustomer(Customer entity) {
        //
    }

    public void deleteCustomer(Customer c) {
        try {
            String query = "DELETE FROM customer WHERE id = "+c.getId();
            this.getDb().prepareStatement(query).executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
    
}
