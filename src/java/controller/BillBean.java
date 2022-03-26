
package controller;

import dao.BillDAO;
import entity.Bill;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Named(value = "billBean")
@SessionScoped
public class BillBean implements Serializable {
    private BillDAO billDao;
    public BillBean() {
    }

    public BillDAO getBillDao() {
        if(this.billDao==null){
            this.billDao=new BillDAO();
        }
        return billDao;
    }

    public void setBillDao(BillDAO billDao) {
        this.billDao = billDao;
    }
 
 
}
