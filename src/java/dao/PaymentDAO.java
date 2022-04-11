/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Payment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 private Long id;
    private String paymnetType;
    private Float amountPayment;
    private Date paymentDate;
    private Long CustomerId;
 */
public class PaymentDAO {
    
     private Connection db;
    
     public void createPayment(Payment payment) {
        try {
            Statement st = this.getDb().createStatement();
            String query = "INSERT INTO payment (paymnetType,amountPayment,paymentDate,CustomerId) VALUES('" + payment.getPaymnetType() + "','" + payment.getAmountPayment() + "','" + payment.getPaymentDate() + "','" + payment.getCustomerId() + "')";
            int r = st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
     public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();
            String query = "select * from payment";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                payments.add(new Payment(rs.getLong("id"), rs.getString("paymnetType"), rs.getFloat("amountPayment"), rs.getDate("paymentDate"), rs.getLong("CustomerId")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return payments;
    }
     
     public void updatePayment(Payment payment) {
        try {
            String query = "UPDATE payment SET paymentType='" + payment.getPaymnetType() + "', amountPayment='" + payment.getAmountPayment() + "', paymentDate='" + payment.getPaymentDate() + "', customerId='" + payment.getCustomerId() + "'  WHERE id='" + payment.getId() + "'";
            this.getDb().prepareStatement(query).executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
     public void deletePayment(Long paymentType) {
        try {
            String query = "DELETE FROM payment WHERE paymentType = '" + paymentType + "'";
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
