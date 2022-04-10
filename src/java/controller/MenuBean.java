/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.MenuDAO;
import entity.Menu;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Ali
 */
@Named(value = "menuBean")
@SessionScoped
public class MenuBean implements Serializable {

    private MenuDAO menuDao;
    private List<Menu> menus;
    private Menu entity;

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

    public List<Menu> getMenus() {
        return this.getMenuDao().getAllMenus();
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public Menu getEntity() {
        if(this.entity==null){
            this.entity=new Menu();
        }
        return entity;
    }

    public void setEntity(Menu entity) {
        this.entity = entity;
    }

   
    public String saveMenu() {
        this.getMenuDao().createMenu(this.getEntity());
        return "index.xhtml";
    }
    
    public String updateMenu() {
        this.getMenuDao().updateMenu(this.getEntity());
        return "index.xhtml";
    }
    
    public String deleteMenu() {
        this.getMenuDao().deleteMenu(this.getEntity().getId());
        return "index.xhtml";
    }

}
