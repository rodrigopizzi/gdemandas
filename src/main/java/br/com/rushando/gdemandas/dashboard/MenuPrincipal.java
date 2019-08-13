package br.com.rushando.gdemandas.dashboard;

import java.util.ArrayList;
import java.util.List;

public class MenuPrincipal {
    private List<Menu> menus = new ArrayList<>();

    public List<Menu> getMenus() {
        return menus;
    }

    public void addMenu(Menu menu) {
        this.menus.add(menu);
    }
}