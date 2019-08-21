package br.com.rushando.gdemandas.services.demanda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.rushando.gdemandas.demanda.DemandaService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CadastrarDemandaTests {
	
//	@Mock
//	DemandaRepository demandaRepository;
	
    @InjectMocks
    DemandaService demandaService;
	
	@Test
	public void cadastrarDemanda() throws Exception {
//		Demanda demanda = new Demanda();

//		Mockito.when(demandaRepository.save(demanda)).then(new Answer<Demanda>() {
//			@Override
//			public Demanda answer(InvocationOnMock invocation) throws Throwable {
//				Demanda d = new Demanda();
//				d.setId(1L);
//				return d;
//			}
//		});
//		
//		Demanda novaDemanda = demandaService.cadastrarDemanda(demanda);
//		Assert.assertTrue("Garante que tenha ao menos uma demanda no banco de dados", novaDemanda.getId() > 0);
	}
	
}
