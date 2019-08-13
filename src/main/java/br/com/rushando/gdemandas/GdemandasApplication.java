package br.com.rushando.gdemandas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.ApplicationScope;

import br.com.rushando.gdemandas.dashboard.Menu;
import br.com.rushando.gdemandas.dashboard.MenuPrincipal;

@SpringBootApplication
public class GdemandasApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(GdemandasApplication.class, args);
		
		MenuPrincipal menuPrincipal = (MenuPrincipal) ctx.getBean("menuPrincipal");
		menuPrincipal.addMenu(new Menu("Dashboard", "fas fa-tachometer-alt", "/dashboard"));
		menuPrincipal.addMenu(new Menu("Demanda", "far fa-credit-card", "/demanda"));
	} 

	@Bean
	@ApplicationScope
	public MenuPrincipal menuPrincipal() {
		return new MenuPrincipal();
	}

}
