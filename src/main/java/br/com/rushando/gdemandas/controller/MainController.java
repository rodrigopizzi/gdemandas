package br.com.rushando.gdemandas.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;


public class MainController {

	@ModelAttribute("menus")
	public List<String> populateTypes() {
	    return Arrays.asList("Menu Item 1", "Menu Item 2", "Menu 3");
	}
	
}
