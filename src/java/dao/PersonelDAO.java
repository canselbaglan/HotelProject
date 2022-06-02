/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;



import entity.Personel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;


/**
 *
 * @author CANSEL
 */
public class PersonelDAO {
    
    private Connection db ;
    
    
    

    public Connection getDb() {
        
        
        if(this.db==null){
           DBConnection dbc= new DBConnection();
           this.db = dbc.connect();
       }
        
        return db;
    }

    
    
    public void setDb(Connection db) {
        this.db = db;
    }
    
    
    public void createPersonel(Personel p){

    try {

           
           Statement st =this.getDb().createStatement();
           
           
           String query = "insert into personel (ad,soyad,tc,tel,dogumyer)values('"+p.getAd()+"' , '"+p.getSoyad()+"','"+p.getTc()+"','"+p.getTel()+"','"+p.getDogumyer()+"')";
           
           int r = st.executeUpdate(query);
           
          
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

       
    }
    
    
     public List <Personel> getPersonelList(){
        
        List<Personel> personelList = new ArrayList<>();// arraylist türünde bir nesne oluşturuyorum.
        
        try {

             Statement st =this.getDb().createStatement();//bu statement bizim sorguları çalıştırmamıza yarayan nesne
  
            //veri çekme kodu:
            String query ="select * from personel";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){//burası bir işlem yapmıcak burası veritabanında gerekli işlemleri yapan metod ekrana yazdırma işlemi yapmıyor println falan yok
                //SADECE ÇAĞIRANA İSTEDİĞİ BİLGİYİ DÖNÜŞ YAPIYOR
                //döngü içinde kaç nesnemiz varsa o kadar nesne cekiyorduk veriatabnından şimdi ise napıcaz  kac satır varsa o kadar nesne oluşturcaz
                //yani yukarıdaki oluşturmuş oldugumuz categoryList.add diyoruz ve her seferinde yeni bir category oluşturuyorum.
                //yeni oluşturulan kategoide hangi alanlarımız olacaksa ekliyorum.
                personelList.add(new Personel(rs.getLong("id"),rs.getString("ad"),rs.getString("soyad"),rs.getLong("tc"),rs.getLong("tel"),rs.getString("dogumyer")));
            }
           
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return personelList;
    }
    
    
    
    public void delete(Personel p){
    
    try {

           
           Statement st =this.getDb().createStatement();//burası artık this değil this.getDb çünkü getDb metodu ne yapıordu bir tane Connection metodu return ediyordu yukarıda bana ona ihtiyacım var
           
           
           String query = "delete from personel where id="+p.getId();
           //yani id si bana parametre olarak gelen categorye eşit olan nesneyi silicek
           int r = st.executeUpdate(query);
          
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
     public void update(Personel p){
        
        try {

           
           Statement st =this.getDb().createStatement();
           
           
           String query = "update personel set ad= '"+p.getAd()+"' where id="+p.getId();
           
           int r = st.executeUpdate(query);
          
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    
    
    
    
    
}
