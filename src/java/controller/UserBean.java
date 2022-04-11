/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;
import dao.UserDAO;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author hilaa
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    private UserDAO userDao;
    
     public UserDAO getUserDao() {
        if (this.userDao == null) {
            this.userDao = new UserDAO();
        }
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    public User getEntity() {
        return entity;
    }

    public void setEntity(User entity) {
        this.entity = entity;
    }
   
    private User entity;
    
    public String create(){
        //return yapıldığında gidilecek sayfa belirtilir.
        return "index";
    }
   
    public UserBean() {
    }
    
}
