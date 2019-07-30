package br.com.rushando.gdemandas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController extends MainController {
	
	@GetMapping("")
    public String index(Model model) {
        return "/dashboard/index";
    }

}
