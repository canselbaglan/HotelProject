/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.CustomerDAO;
import entity.Customer;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author CANSEL
 */
@Named(value = "customerBean")
@SessionScoped
public class CustomerBean implements Serializable {

    private CustomerDAO customerDao;
    private List<Customer> customers;
    private Customer entity;

    public CustomerBean() {
     
    }
        public CustomerDAO getCustomerDao() {
        if (this.customerDao == null) {
            this.customerDao = new CustomerDAO();
        }
        return customerDao;
    }
        
        
    public void setCustomerDao(CustomerDAO customerDao) {
         this.customerDao = customerDao;
    }

    public List<Customer> getCustomer() {
        return this.getCustomerDao().getAllCustomers();
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    
     public Customer getEntity() {
        if(this.entity==null){
            this.entity=new Customer();
        }
        return entity;
    }

    public void setEntity(Customer entity) {
        this.entity = entity;
    }

    
    public String saveCustomer() {
        this.getCustomerDao().createCustomer(this.getEntity());
        return "index.xhtml";
    }
    
    public String updateCustomer() {
        this.getCustomerDao().updateCustomer(this.getEntity());
        return "index.xhtml";
    }
    
    public String deleteCustomer() {
        this.getCustomerDao().deleteCustomer(this.getEntity().getId());
        return "index.xhtml";
    }
}
