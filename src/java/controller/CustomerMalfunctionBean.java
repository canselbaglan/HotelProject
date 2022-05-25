/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import jakarta.inject.Named;
import jakarta.enterprise.context.Dependent;
import dao.CustomerMalfunctionDAO;
import entity.CustomerMalfunction;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


/**
 *
 * @author CANSEL
 */
@Named(value = "customerMalfunctionBean")
@Dependent
public class CustomerMalfunctionBean implements Serializable {

    private CustomerMalfunction customermalfunction;
    private CustomerMalfunctionDAO customermalfunctionDao;
    private List<CustomerMalfunction> customermalfunctions;
    private CustomerMalfunction entity;
    private Integer customermalfunctionId;

    /**
     * Creates a new instance of CustomerMalfunctionBean
     */
    
        
        
        
   
   

    

    public CustomerMalfunctionDAO getCustomerMalfunctionDao() {
        if (this.customermalfunctionDao == null) {
            this.customermalfunctionDao = new CustomerMalfunctionDAO();
        }
        return customermalfunctionDao;
    }

    public void setMenuDao(CustomerMalfunctionDAO customermalfunctionDao) {
        this.customermalfunctionDao= customermalfunctionDao;
    }

    public List<CustomerMalfunction> getCustomerMalfunctions() {
        return this.getCustomerMalfunctionDao().getAllCustomerMalfunctions();
    }

    public void setCustomerMalfunctions(List<CustomerMalfunction> customermalfunctions) {
        this.customermalfunctions = customermalfunctions;
    }

    public CustomerMalfunction getEntity() {
        if(this.entity==null){
            this.entity=new CustomerMalfunction();
        }
        return entity;
    }

    public void setEntity(CustomerMalfunction entity) {
        this.entity = entity;
    }

   
    public String saveCustomerMalfunction() {
        this.getCustomerMalfunctionDao().createCustomerMalfunction(this.getEntity());
        return "index.xhtml";
    }
    
    public String updateCustomerMalfunction() {
        this.getCustomerMalfunctionDao().updateCustomerMalfunction(this.getEntity());
        return "index.xhtml";
    }
    
    public String deleteCustomerMalfunction() {
        this.getCustomerMalfunctionDao().deleteCustomerMalfunction(this.getEntity().getId());
        return "index.xhtml";
    }

    public Integer getCustomerMalfunctionId() {
        if(this. customermalfunctionId==null){
            this. customermalfunctionId=0;
        }
        return  customermalfunctionId;
    }

    public void setMenuId(Integer customermalfunctionId) {
        this.customermalfunctionId =  customermalfunctionId;
    }

 
     public CustomerMalfunction getCustomerMalfunction() {
        return this.getCustomerMalfunctionDao().getCustomerMalfunctions(this.customermalfunctionId);
    }

    public void setMenu(CustomerMalfunction customermalfunction) {
        this.customermalfunction = customermalfunction;
    }

  
    
    }
    

