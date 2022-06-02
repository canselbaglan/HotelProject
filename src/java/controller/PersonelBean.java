/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;


import java.io.Serializable;
import dao.PersonelDAO;
import entity.Personel;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.sql.Timestamp;


/**
 *
 * @author CANSEL
 */
@Named(value = "personelBean")
@SessionScoped
public class PersonelBean implements Serializable {

    /**
     * Creates a new instance of PersonelBean
     */
    
    private Personel entity;
    private PersonelDAO dao;
    private List<Personel>list;
    
    public PersonelBean() {
    }

    public Personel getEntity() {
        if(this.entity == null){//Ayrıyeten erişim yapacagım bütün nesnelrin null olmadıgından da if ile emin oluyorum.
            this.entity = new Personel();//eger null ise yenisini oluştur diyecem.
        }
        return entity;
    }

    public void setEntity(Personel entity) {
        this.entity = entity;
    }

    public PersonelDAO getDao() {
        if(this.dao ==null){
         this.dao = new PersonelDAO();
        }
        return dao;
    }

    public void setDao(PersonelDAO dao) {
        this.dao = dao;
    }

    public List<Personel> getList() {
        this.list = this.getDao().getPersonelList();
        return list;
    }

    public void setList(List<Personel>list) {
        this.list = list;
    }
 
    
    public String create(){ 
        this.getDao().createPersonel(entity); //Şimdi bu nesneyi dao sınıfına göndereceğiz ve oluşturmuş olucaz.
        this.entity= new Personel(); //butona basma işleminden sonra içini boşaltmak için bunu yazıyoruz
        
         return "personel";

    }
    
    
     public void delete(Personel p){
        
        this.getDao().delete(p);//ile kategoriyi silme işlemi gerçekleştiriyoruz.
    }
    
    public String update(){
        
        this.getDao().update(this.entity);
        this.entity= new Personel();
        
         return "personel";

    }
    
    
    
    
}
