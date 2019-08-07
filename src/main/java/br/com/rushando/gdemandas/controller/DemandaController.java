package br.com.rushando.gdemandas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rushando.gdemandas.demanda.Demanda;
import br.com.rushando.gdemandas.demanda.DemandaService;
import br.com.rushando.gdemandas.demanda.Demanda.Status;

@Controller
@RequestMapping("/demanda")
public class DemandaController extends MainController {
	
	@Autowired
	private DemandaService service;
	
	@GetMapping("")
    public String index(Model model) {
		model.addAttribute("demandas", service.listAll());
        return "/demanda/index";
	}
	
	@GetMapping("add")
    public String add(Model model) {
		model.addAttribute("demanda", new Demanda());
		return "/demanda/edit";
    }
	
	@PostMapping("add")
    public String add(Demanda demanda) {
		service.cadastrarDemanda(demanda);
		return "redirect:/demanda";
    }
}
