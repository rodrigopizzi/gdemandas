package br.com.rushando.gdemandas.services.demanda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.rushando.gdemandas.demanda.DemandaService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CancelarDemandaTests {
	
//	@Mock
//	DemandaRepository demandaRepository;
	
    @InjectMocks
    DemandaService demandaService;

	@Test
	public void cancelarDemanda() {
		// TODO Não implementado
	}
	
}
