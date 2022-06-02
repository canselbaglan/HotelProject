/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author CANSEL
 */
public class Personel {
    
    private Long id;
    private String ad;
    private String soyad;
    private Long tc;
    private Long tel;
    private String dogumyer;

    public Personel() {
    }

    public Personel(Long id, String ad, String soyad, Long tc, Long tel, String dogumyer) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.tc = tc;
        this.tel = tel;
        this.dogumyer = dogumyer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public Long getTc() {
        return tc;
    }

    public void setTc(Long tc) {
        this.tc = tc;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public String getDogumyer() {
        return dogumyer;
    }

    public void setDogumyer(String dogumyer) {
        this.dogumyer = dogumyer;
    }

    @Override
    public String toString() {
        return "Personel{" + "id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", tc=" + tc + ", tel=" + tel + ", dogumyer=" + dogumyer + '}';
    }
    
    
    
    
    
    
}
