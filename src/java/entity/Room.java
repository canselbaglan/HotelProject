/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Ali
 */
public class Room {
    private Long id;
    private Long roomNo;
    private Long bedNumber;
    private String location;
    private Boolean isFull;

    public Room() {
    }

    public Room(Long id, Long roomNo, Long bedNumber, String location, Boolean isFull) {
        this.id = id;
        this.roomNo = roomNo;
        this.bedNumber = bedNumber;
        this.location = location;
        this.isFull = isFull;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Long roomNo) {
        this.roomNo = roomNo;
    }

    public Long getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(Long bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getIsFull() {
        return isFull;
    }

    public void setIsFull(Boolean isFull) {
        this.isFull = isFull;
    }
    
}
