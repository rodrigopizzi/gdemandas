package br.com.rushando.gdemandas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import br.com.rushando.gdemandas.dashboard.Menu;
import br.com.rushando.gdemandas.dashboard.MenuPrincipal;

@Component
public abstract class MainController {

	@Autowired
	private MenuPrincipal menuPrincipal;

	@ModelAttribute("menus")
	public List<Menu> populateTypes() {
		return menuPrincipal.getMenus();
	}
	
}
