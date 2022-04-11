/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.PaymentDAO;
import entity.Payment;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author hilaa
 */
@Named(value = "paymentBean")
@SessionScoped
public class PaymentBean implements Serializable {

    private PaymentDAO paymentDao;
   
    private Payment entity;
    

    public PaymentBean() {
    }
    
    public PaymentDAO getPaymentDao() {
        if (this.paymentDao == null) {
            this.paymentDao= new PaymentDAO();
        }
        return paymentDao;
    }
    
    public Payment getEntity() {
        if(this.entity==null){
            this.entity=new Payment();
        }
        return entity;
    }

    public void setEntity(Payment entitiy) {
        this.entity = entity;
    }
    
    public String savePayment() {
        this.getPaymentDao().createPayment(this.getEntity());
        return "index.xhtml";
    }
    
    public String updatePayment() {
        this.getPaymentDao().updatePayment(this.getEntity());
        return "index.xhtml";
    }
    
    
}
