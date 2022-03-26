
package entity;

import java.util.Date;


public class Bill {
    private Long id;
    private Long customerid;
    private Date date;
    private Float total;

    public Bill() {
    }

    public Bill(Long id, Long customerid, Date date, Float total) {
        this.id = id;
        this.customerid = customerid;
        this.date = date;
        this.total = total;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
    
    
}
