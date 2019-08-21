package br.com.rushando.gdemandas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.rushando.gdemandas.demanda.ClassificarDTO;
import br.com.rushando.gdemandas.demanda.DemandaDTO;
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
		model.addAttribute("demanda", new DemandaDTO());
		model.addAttribute("action", "/demanda/add");
		return "/demanda/edit";
    }
	
	@PostMapping("add")
    public String add(DemandaDTO dto) {
		service.cadastrar(dto);
		return "redirect:/demanda";
	}
	
	@GetMapping("edit/{iddemanda}")
    public String edit(@PathVariable("iddemanda") Long idDemanda, Model model) {
		model.addAttribute("demanda", service.demandaDTOById(idDemanda));
		model.addAttribute("action", "/demanda/edit");
		return "/demanda/edit";
	}

	@PostMapping("edit")
    public String edit(DemandaDTO dto) {
		service.editar(dto);
		return "redirect:/demanda";
	}
	
	@PostMapping("delete")
	public String delete(@RequestParam("id") Long idDemanda) {
		service.deletar(idDemanda);
		return "redirect:/demanda";
	}

	@GetMapping("classificar/{iddemanda}")
    public String classificar(@PathVariable("iddemanda") Long idDemanda, Model model) {
		model.addAttribute("demanda", service.classificarDTOById(idDemanda));
		return "/demanda/classificar";
	}

	@PostMapping("classificar")
    public String classificar(ClassificarDTO dto) throws Exception {
		service.classificar(dto);
		return "redirect:/demanda";
	}

	
}
