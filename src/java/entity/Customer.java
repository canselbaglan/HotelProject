
package entity;

import java.util.Date;

public class Customer {
    private Long id;
    private String name;
    private String surname;
    private Long phonenumber;
    private Date customerlogin;
    private Date customerexit;
    private Long RoomID;

    public Customer() {
    }

    public Customer(Long id, String name, String surname, Long phoneNumber, Date customerlogin, Date customerexit, Long RoomID) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phonenumber = phoneNumber;
        this.customerlogin = customerlogin;
        this.customerexit = customerexit;
        this.RoomID = RoomID;
    }

    public Customer(Long id, String name, String surname, Long phonenumber, Date customerlogin, Long RoomID) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phonenumber = phonenumber;
        this.customerlogin = customerlogin;
        this.RoomID = RoomID;
    }
    
    
    
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

    public Long getPhoneNumber() {
        return phonenumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phonenumber = phonenumber;
    }

    public Date getCustomerLogin() {
        return customerlogin;
    }

    public void setCustomerLogin(Date customerLogin) {
        this.customerlogin = customerLogin;
    }

    public Date getCustomerExit() {
        return customerexit;
    }

    public void setCustomerExit(Date customerExit) {
        this.customerexit = customerExit;
    }

    public Long getRoomID() {
        return RoomID;
    }

    public void setRoomID(Long RoomID) {
        this.RoomID = RoomID;
    }
    
    
    
}
