package br.com.rushando.gdemandas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rushando.gdemandas.demanda.DemandaService;

@Controller
@RequestMapping("demanda")
public class DemandaController {
	
	@Autowired
	private DemandaService service;
	
	@GetMapping("")
    public String greeting(Model model) {
		model.addAttribute("demandas", service.listAll());
        return "demanda/index";
    }

}
