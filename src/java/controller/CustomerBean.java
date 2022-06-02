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

    /**
     * Creates a new instance of CustomerBean
     */
    
    private Customer entity;
    private CustomerDAO dao;
    private List<Customer>list;
    
    
    public CustomerBean() {
    }
    
    
    public Customer getEntity() {
        if(this.entity == null){//Ayrıyeten erişim yapacagım bütün nesnelrin null olmadıgından da if ile emin oluyorum.
            this.entity = new Customer ();//eger null ise yenisini oluştur diyecem.
        }
        return entity;
    }

    public void setEntity(Customer entity) {
        this.entity = entity;
    }

    public CustomerDAO getDao() {
        if(this.dao ==null){
         this.dao = new CustomerDAO();
        }
        return dao;
    }

    public void setDao(CustomerDAO dao) {
        this.dao = dao;
    }

    public List<Customer> getList() {
        this.list = this.getDao().getCustomerList();
        return list;
    }

    public void setList(List<Customer> list) {
        this.list = list;
    }
    
    
      public String create(){ //title ı xhtml kısmında set ile aldım o yuzden burdayok
      
        this.getDao().createCustomer(entity); //Şimdi bu nesneyi dao sınıfına göndereceğiz ve oluşturmuş olucaz.
        this.entity= new Customer(); //butona basma işleminden sonra içini boşaltmak için bunu yazıyoruz
        
         return "customer";

    }
    
    
      public void delete(Customer c){
        
        this.getDao().delete(c);//ile kategoriyi silme işlemi gerçekleştiriyoruz.
    }
    
     public String update(){
        
        this.getDao().update(this.entity);
        this.entity= new Customer();
        
         return "customer";

    }
    
}
