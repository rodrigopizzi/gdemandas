package br.com.rushando.gdemandas;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.rushando.gdemandas.demanda.Demanda;
import br.com.rushando.gdemandas.demanda.Demanda.Status;
import br.com.rushando.gdemandas.demanda.Demanda.Tamanho;
import br.com.rushando.gdemandas.demanda.DemandaService;

@SpringBootApplication
public class GdemandasApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(GdemandasApplication.class, args);
		DemandaService service = ctx.getBean(DemandaService.class);
		
		Demanda demanda = new Demanda(1L, "PRD 2019 - 001 - Tegma", "Novo Campo na tela de contrato de cobrança", Status.Backlog, null, new Date(), Tamanho.Enorme, null);
		service.cadastrarDemanda(demanda);
		
	} 

}
