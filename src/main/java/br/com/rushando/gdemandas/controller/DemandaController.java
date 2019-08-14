package br.com.rushando.gdemandas.controller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.rushando.gdemandas.demanda.Demanda;
import br.com.rushando.gdemandas.demanda.DemandaService;

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
	
	@GetMapping("edit/{iddemanda}")
    public String edit(@PathVariable("iddemanda") Long idDemanda, Model model) {
		model.addAttribute("demanda", service.getById(idDemanda));
		return "/demanda/edit";
	}
	
	@PostMapping("delete")
	public String delete(@RequestParam("id") Long idDemanda) {
		service.delete(idDemanda);
		return "redirect:/demanda";
	}

	@GetMapping("classificar/{iddemanda}")
    public String classificar(@PathVariable("iddemanda") Long idDemanda, Model model) {
		model.addAttribute("demanda", service.getById(idDemanda));
		return "/demanda/classificar";
	}

	
}
