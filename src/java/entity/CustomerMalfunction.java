/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Ali
 */
public class CustomerMalfunction {
    private Long id;
    private Long malfunctionId;
    private Long customerId;

    public CustomerMalfunction() {
    }

    public CustomerMalfunction(Long id, Long malfunctionId, Long customerId) {
        this.id = id;
        this.malfunctionId = malfunctionId;
        this.customerId = customerId;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMalfunctionId() {
        return malfunctionId;
    }

    public void setMalfunctionId(Long malfunctionId) {
        this.malfunctionId = malfunctionId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    
    
}
