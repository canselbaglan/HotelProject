
package entity;

import java.util.Date;

public class Customer {
    private Long id;
    private String name;
    private String surname;
    private Long phoneNumber;
    private Date customerLogin;
    private Date customerExit;
    private Long RoomID;

    public Customer() {
    }

    public Customer(Long id, String name, String surname, Long phoneNumber, Date customerLogin, Date customerExit, Long RoomID) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.customerLogin = customerLogin;
        this.customerExit = customerExit;
        this.RoomID = RoomID;
    }

    public Customer(Long id, String name, String surname, Long phoneNumber, Date customerLogin, Long RoomID) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.customerLogin = customerLogin;
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
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getCustomerLogin() {
        return customerLogin;
    }

    public void setCustomerLogin(Date customerLogin) {
        this.customerLogin = customerLogin;
    }

    public Date getCustomerExit() {
        return customerExit;
    }

    public void setCustomerExit(Date customerExit) {
        this.customerExit = customerExit;
    }

    public Long getRoomID() {
        return RoomID;
    }

    public void setRoomID(Long RoomID) {
        this.RoomID = RoomID;
    }
    
    
    
}
