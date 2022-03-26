/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Ali
 */
public class RoomMalfunction {
    private Long id;
    private Long roomId;
    private Long malfunctionId;

    public RoomMalfunction() {
    }

    public RoomMalfunction(Long id, Long roomId, Long malfunctionId) {
        this.id = id;
        this.roomId = roomId;
        this.malfunctionId = malfunctionId;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getMalfunctionId() {
        return malfunctionId;
    }

    public void setMalfunctionId(Long malfunctionId) {
        this.malfunctionId = malfunctionId;
    }
    
    
}
