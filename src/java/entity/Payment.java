/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author Ali
 */
public class Payment {
    private Long id;
    private String paymnetType;
    private Float amountPayment;
    private Date paymentDate;
    private Long CustomerId;

    public Payment() {
    }

    public Payment(Long id, String paymnetType, Float amountPayment, Date paymentDate, Long CustomerId) {
        this.id = id;
        this.paymnetType = paymnetType;
        this.amountPayment = amountPayment;
        this.paymentDate = paymentDate;
        this.CustomerId = CustomerId;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymnetType() {
        return paymnetType;
    }

    public void setPaymnetType(String paymnetType) {
        this.paymnetType = paymnetType;
    }

    public Float getAmountPayment() {
        return amountPayment;
    }

    public void setAmountPayment(Float amountPayment) {
        this.amountPayment = amountPayment;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Long getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(Long CustomerId) {
        this.CustomerId = CustomerId;
    }
    
    
    
}
