/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


/**
 *
 * @author CANSEL
 */

import entity.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class CustomerDAO {
    
    
     private Connection db ;

     
     
    public Connection getDb() {
          if(this.db==null){
           DBConnection dbc= new DBConnection();
           this.db = dbc.connect();
       }
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }
     
     
     public void createCustomer(Customer c){

    try {

           
           Statement st =this.getDb().createStatement();
           
           
           String query = "insert into customer (name,surname,phonenumber,customerlogin,customerexit,roomid)values('"+c.getName()+"' ,'"+c.getSurname()+"','"+c.getPhonenumber()+"','"+c.getCustomerlogin()+"','"+c.getCustomerexit()+"','"+c.getRoomid()+"')";
           
           int r = st.executeUpdate(query);
           
          
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

       
    }
    
    
     
     
      public List <Customer> getCustomerList(){
        
        List<Customer> customerList = new ArrayList<>();// arraylist türünde bir nesne oluşturuyorum.
        
        try {

             Statement st =this.getDb().createStatement();//bu statement bizim sorguları çalıştırmamıza yarayan nesne
  
            //veri çekme kodu:
            String query ="select * from customer";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){//burası bir işlem yapmıcak burası veritabanında gerekli işlemleri yapan metod ekrana yazdırma işlemi yapmıyor println falan yok
                //SADECE ÇAĞIRANA İSTEDİĞİ BİLGİYİ DÖNÜŞ YAPIYOR
                //döngü içinde kaç nesnemiz varsa o kadar nesne cekiyorduk veriatabnından şimdi ise napıcaz  kac satır varsa o kadar nesne oluşturcaz
                //yani yukarıdaki oluşturmuş oldugumuz categoryList.add diyoruz ve her seferinde yeni bir category oluşturuyorum.
                //yeni oluşturulan kategoide hangi alanlarımız olacaksa ekliyorum.
                customerList.add(new Customer(rs.getLong("id"),rs.getString("name"),rs.getString("surname"),rs.getLong("phonenumber"),rs.getDate("customerlogin"),rs.getDate("customerexit"),rs.getLong("roomid")));
            }
           
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return customerList;
    }
      
      
      
      
      public void delete(Customer c){
    
    try {

           
           Statement st =this.getDb().createStatement();//burası artık this değil this.getDb çünkü getDb metodu ne yapıordu bir tane Connection metodu return ediyordu yukarıda bana ona ihtiyacım var
           
           
           String query = "delete from customer where id="+c.getId();
           //yani id si bana parametre olarak gelen categorye eşit olan nesneyi silicek
           int r = st.executeUpdate(query);
          
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
      
      
      
       public void update(Customer c){
        
        try {

           
           Statement st =this.getDb().createStatement();
           
           
           String query = "update customer set name= '"+c.getName()+"' where id="+c.getId();
           
           int r = st.executeUpdate(query);
          
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
       }
}
