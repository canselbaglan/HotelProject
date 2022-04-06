/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.MenuDAO;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

/**
 *
 * @author Ali
 */
@Named(value = "menuBean")
@SessionScoped
public class MenuBean {

    private MenuDAO menuDao;

    public MenuBean() {
    }

    public MenuDAO getMenuDao() {
        if (this.menuDao == null) {
            this.menuDao = new MenuDAO();
        }
        return menuDao;
    }

    public void setMenuDao(MenuDAO menuDao) {
        this.menuDao = menuDao;
    }

}
