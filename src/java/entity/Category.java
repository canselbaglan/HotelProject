/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;//date kütüphane
import java.sql.Timestamp;

/**
 *
 * @author CANSEL
 */
public class Category {

    //veritabındaki column alanları tanımlıyoruz.
    private Long id;
    private String name;
    private Timestamp created;
    private Timestamp updated;

    //bir boş constructer her zaman tanımlanır.
    public Category() {
    }

    //bir tane full constructer her zaman tanımlanır.
    //updated'e ihtiyacım olunca burayı kullanıcam
    public Category(Long id, String name, Timestamp created, Timestamp updated) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.updated = updated;
    }

    //şuanki category sınıfına has bu drum için bir tane daha tanımlıcam.updated otomatik olarak olacagı için onu içermeyen tanımlıyorum.
    //updated' e ihtiyacım olmayan zamanlarda burayı kullancam
    public Category(String title, Timestamp created) {
        this.id = id;
        this.name = title;
        this.created = created;
    }

    // getter setter metodlarını oluşturuyoruz tamamı için
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    
    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", created=" + created + ", updated=" + updated + '}';
    }

   
    
    
    
}
