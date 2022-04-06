/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.RoomDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

/**
 *
 * @author Ali
 */
@Named(value = "roomBean")
@SessionScoped
public class RoomBean {

    private RoomDAO roomDao;

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

}
