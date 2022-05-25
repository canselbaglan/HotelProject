
package entity;

import java.util.Date;

public class Customer { //veritabanımda kullandığım isimde bir nesne tanımlıyorum
    //veritabanındaki alanları buraya yazıyorum
    private Long id;
    private String name;
    private String surname;
    private Long phonenumber;
    private Date customerlogin;
    private Date customerexit;
    private Long roomid;

    
    // 1 adet bos contructer ve 1 adet full constructer her zaman tanımlanmalıdır.
    
    public Customer() { 
    //boş constructer tanımladım
    }

    public Customer(Long id, String name, String surname, Long phonenumber, Date customerlogin, Date customerexit, Long roomid) {
        // full constructer tanımladım
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phonenumber = phonenumber;
        this.customerlogin = customerlogin;
        this.customerexit = customerexit;
        this.roomid = roomid;
    }

 
    
    
    
    //tamamı için getter setter metodlarını oluşturdum.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Date getCustomerlogin() {
        return customerlogin;
    }

    public void setCustomerlogin(Date customerlogin) {
        this.customerlogin = customerlogin;
    }

    public Date getCustomerexit() {
        return customerexit;
    }

    public void setCustomerexit(Date customerexit) {
        this.customerexit = customerexit;
    }

    public Long getRoomid() {
        return roomid;
    }

    public void setRoomid(Long roomid) {
        this.roomid = roomid;
    }

    public Long getCustomerId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
 

   
}
