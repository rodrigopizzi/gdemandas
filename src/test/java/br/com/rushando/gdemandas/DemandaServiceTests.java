package br.com.rushando.gdemandas;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.rushando.gdemandas.domain.Demanda;
import br.com.rushando.gdemandas.domain.Demanda.CadastroInvalidoException;
import br.com.rushando.gdemandas.domain.Demanda.Status;
import br.com.rushando.gdemandas.repository.DemandaRepository;
import br.com.rushando.gdemandas.service.DemandaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemandaServiceTests {
	
	@Autowired
	private DemandaRepository demandaRepository;

	@Autowired
	private DemandaService demandaService;

	@Test
	public void cadastrarDemanda() throws Exception {
		Demanda demanda = new Demanda(null, "Observação NFe",
				"Adicionar informação observação na nota fiscal eletronica", Status.Backlog, null);

		demandaService.cadastrarDemanda(demanda);
		
		Iterable<Demanda> demandas = demandaRepository.findAll();
		Assert.assertTrue("Garante que tenha ao menos uma demanda no banco de dados", demandas.iterator().hasNext());
	}
	
	@Test(expected=CadastroInvalidoException.class)
	public void impedirCadastroInvalido() throws CadastroInvalidoException {
		Demanda demanda = new Demanda(null, "Observação NFe",
				"Adicionar informação observação na nota fiscal eletronica", Status.Classificado, null);

		demandaService.cadastrarDemanda(demanda);
	}

}
