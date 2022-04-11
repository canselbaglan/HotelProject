
package controller;

import dao.MalfunctionDAO;
import entity.Malfunction;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


@Named(value = "malfunctionBean")
@SessionScoped
public class MalfunctionBean implements Serializable {

    private MalfunctionDAO malfunctionDao;
    private List<Malfunction> malfunctions;
    private Malfunction entity;
    private Malfunction malfunction;
    private Integer malfunctionId;
    
    public MalfunctionBean() {
    }

    public MalfunctionDAO getMalfunctionDao() {
        if (this.malfunctionDao == null) {
            this.malfunctionDao = new MalfunctionDAO();
        }
        return malfunctionDao;
    }

    public void setMalfunctionDao(MalfunctionDAO malfunctionDao) {
        this.malfunctionDao = malfunctionDao;
    }

    public List<Malfunction> getMalfunctions() {
        return this.getMalfunctionDao().getAllMalfunctions();
    }

    public void setMalfunctions(List<Malfunction> malfunctions) {
        this.malfunctions = malfunctions;
    }


    public Malfunction getEntity() {
        if(this.entity==null){
            this.entity=new Malfunction();
        }
        return entity;
    }

    public void setEntity(Malfunction entity) {
        this.entity = entity;
    }
    
    
    public String saveMalfunction() {
        entity.setDate(new Timestamp(System.currentTimeMillis()));
        this.getMalfunctionDao().createMalfunction(this.getEntity());
        return "index.xhtml";
    }
    
    public String updateMalfunction() {
        entity.setDate(new Timestamp(System.currentTimeMillis()));
        this.getMalfunctionDao().updateMalfunction(this.getEntity());
        return "index.xhtml";
    }
    
    public String deleteMalfunction() {
        this.getMalfunctionDao().deleteMalfunction(this.getEntity().getId());
        return "index.xhtml";
    }

    public Malfunction getMalfunction() {
        return this.getMalfunctionDao().getMalfunction(this.malfunctionId);
    }

    public void setMalfunction(Malfunction malfunction) {
        this.malfunction = malfunction;
    }

    public Integer getMalfunctionId() {
        if(this.malfunctionId==null){
            this.malfunctionId=0;
        }
        return malfunctionId;
    }

    public void setMalfunctionId(Integer malfunctionId) {
        this.malfunctionId = malfunctionId;
    }
    
    
    
    
}
