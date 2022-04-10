/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.RoomDAO;
import entity.Room;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ali
 */
@Named(value = "roomBean")
@SessionScoped
public class RoomBean implements Serializable{

    private RoomDAO roomDao;
    private List<Room> rooms;
    private Room entity;

    public RoomBean() {
    }

    public RoomDAO getRoomDao() {
        if (this.roomDao == null) {
            this.roomDao = new RoomDAO();
        }
        return roomDao;
    }

    public void setRoomDao(RoomDAO roomDao) {
        this.roomDao = roomDao;
    }

    public List<Room> getRooms() {
        return this.getRoomDao().getAllRooms();
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Room getEntity() {
        if(this.entity==null){
            this.entity=new Room();
        }
        return entity;
    }

    public void setEntity(Room entitiy) {
        this.entity = entity;
    }
    
    public String saveRoom() {
        this.getRoomDao().createRoom(this.getEntity());
        return "index.xhtml";
    }
    
    public String updateRoom() {
        this.getRoomDao().updateRoom(this.getEntity());
        return "index.xhtml";
    }
    
    public String deleteRoom() {
        this.getRoomDao().deleteRoom(this.getEntity().getRoomNo());
        return "index.xhtml";
    }
    
    
    
}
