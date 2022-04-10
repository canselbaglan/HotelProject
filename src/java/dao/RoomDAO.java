/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Room;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author Ali
 */
public class RoomDAO {

    private Connection db;

    public void createRoom(Room room) {
        try {
            Statement st = this.getDb().createStatement();
            String query = "INSERT INTO room (roomno,bednumber,location,isfull) VALUES('" + room.getRoomNo() + "','" + room.getBedNumber() + "','" + room.getLocation() + "','" + room.getIsFull() + "')";
            int r = st.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        try {
            Statement st = this.getDb().createStatement();
            String query = "select * from room";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                rooms.add(new Room(rs.getLong("id"), rs.getLong("roomNo"), rs.getLong("bedNumber"), rs.getString("location"), rs.getBoolean("isFull")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rooms;
    }

    public Room getRoom(int roomNo) {
        Room room = null;
        try {
            Statement st = this.getDb().createStatement();
            String query = "select * from room where roomno='" + roomNo + "' limit 1";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                room = new Room(rs.getLong("id"), rs.getLong("roomNo"), rs.getLong("bedNumber"), rs.getString("location"), rs.getBoolean("isFull"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return room;
    }

    public void updateRoom(Room room) {
        try {
            String query = "UPDATE room SET roomNo='" + room.getRoomNo() + "', bedNumber='" + room.getBedNumber() + "', location='" + room.getLocation() + "', isFull='" + room.getIsFull() + "'  WHERE id='" + room.getId() + "'";
            this.getDb().prepareStatement(query).executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteRoom(Long roomNo) {
        try {
            String query = "DELETE FROM room WHERE roomno = '" + roomNo + "'";
            this.getDb().prepareStatement(query).executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getDb() {
        if (this.db == null) {
            DBConnection dbc = new DBConnection();
            this.db = dbc.connect();
        }
        return db;
    }

    public void setDb(Connection db) {
        this.db = db;
    }
}
