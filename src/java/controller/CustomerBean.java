/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.CustomerDAO;
import entity.Customer;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Date;



/**
 *
 * @author CANSEL
 */
@Named(value = "customerBean")
@SessionScoped

public class CustomerBean implements Serializable {

    private Customer entity;
    private CustomerDAO customerDao;
    private List<Customer> customers;
    private Integer customerId;
    private Customer customer;
  
    
    
    public CustomerBean() {//bos constructer
     
    }

    
    public CustomerDAO getCustomerDao() {
        if(this.customerDao==null){
            this.customerDao=new CustomerDAO();
        }

        return customerDao;
    }
    
    
         
    public void setCustomerDao(CustomerDAO customerDao) {
        this.customerDao =customerDao;
    }
    
      public List<Customer> getCustomers() {
        return this.getCustomerDao().getAllCustomers();
    }

      public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
        
     public Customer getEntity() { //erisim yapacagım butun nesnelerin null olmadıgından emin olmak icin eger null ise yenisi olusturulur
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
     
     
     /*public String deleteCustomer() {
        this.getCustomerDao().deleteCustomer(this.getEntity().getCustomerId());
        return "index.xhtml";
    }*/
  
     
     public Integer getCustomerId() {
        if(this.customerId==null){
            this.customerId=0;
        }
        return customerId;
    }
    
      public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

     
      public Customer getCustomer() {
        return this.getCustomerDao().getCustomer(this.customerId);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
    /*public CustomerBean(Customer entity, CustomerDAO customerDao) {
        this.entity = entity;
        this.customerDao = customerDao;
    }*/
    
    
   
   
    
        
    
}
