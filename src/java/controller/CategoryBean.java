/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.CategoryDAO;
import entity.Category;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.sql.Timestamp;

/**
 *
 * @author CANSEL
 */
@Named(value = "categoryBean")
@SessionScoped
public class CategoryBean implements Serializable {

    private Category entity;//bu benim entity (varlık) sınıfım olacak
    private CategoryDAO dao;// buna da dao ismini veriyorum.
    private List<Category>list;//bir tane category listesi buna da list ismini veriyroum.
    
    //gerekli importlar yapıldı
    
    /**
     * Creates a new instance of CategoryBean
     */
    public CategoryBean() {
    }
    
    
    //Daha sonra bu özelliklerin getter setter metodlarını oluşturuyorum tamamının.
    //Ayrıyeten erişim yapacagım bütün nesnelrin null olmadıgından da if ile emin oluyorum.eger null ise yenisini oluştur diyecem.

    public Category getEntity() {
        if(this.entity == null){//Ayrıyeten erişim yapacagım bütün nesnelrin null olmadıgından da if ile emin oluyorum.
            this.entity = new Category ();//eger null ise yenisini oluştur diyecem.
        }
        return entity;
    }

    public void setEntity(Category entity) {
        this.entity = entity;
    }

    public CategoryDAO getDao() {
        if(this.dao ==null){
         this.dao = new CategoryDAO();
        }
        return dao;
    }

    public void setDao(CategoryDAO dao) {
        this.dao = dao;
    }

    
    //BU KOD CATEGORY NESNESİNİ ÇEKEN KOD:
    public List<Category> getList() {
        this.list = this.getDao().getCategryList();// buradaki kod getDao metoduna gidecek eger getDao  null ise yenisini oluşturacak yok zaten session scope oldugu için
        //daha önceden oluşturdyuysa da var olan nesneye gönderecek ayni sürekli yeni nesne oluşturamış olacaz.
        //bunun bize avantajı: çok fazla veritabanına baflsntı kurulunca yönetilememeye  başlıcak şisecek ve bu hataya düşecek bunu kısmen engellemiş de olacaz.
        return list;
    }

    public void setList(List<Category> list) {
        this.list = list;
    }
    
    
    
    //CREATE METODUNU OLUŞTURUYORUM
    public void create(){ //title ı xhtml kısmında set ile aldım o yuzden burdayok
        this.entity.setCreated(new Timestamp(System.currentTimeMillis()));//created zamanını da ben burda eklemiş oldum.
        this.getDao().createCategory(entity); //Şimdi bu nesneyi dao sınıfına göndereceğiz ve oluşturmuş olucaz.
        this.entity= new Category(); //butona basma işleminden sonra içini boşaltmak için bunu yazıyoruz
        
         //return "category";

    }
    
    
    public void delete(Category c){
        
        this.getDao().delete(c);//ile kategoriyi silme işlemi gerçekleştiriyoruz.
    }
    
    
    public void update(){
        
        this.getDao().update(this.entity);
        this.entity= new Category();
        
         //return "category";

    }
}

