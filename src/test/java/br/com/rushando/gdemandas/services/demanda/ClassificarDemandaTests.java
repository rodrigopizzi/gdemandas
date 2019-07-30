package br.com.rushando.gdemandas.services.demanda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.rushando.gdemandas.demanda.Demanda.TamanhoObrigatiorException;
import br.com.rushando.gdemandas.demanda.DemandaService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ClassificarDemandaTests {
	
//	@Mock
//	DemandaRepository demandaRepository;
	
    @InjectMocks
    DemandaService demandaService;

	@Test
	public void classificarDemanda() throws Exception {
//		Mockito.when(demandaRepository.findById(1L)).then(new Answer<Optional<Demanda>>() {
//			@Override
//			public Optional<Demanda> answer(InvocationOnMock invocation) throws Throwable {
//				Demanda d = new Demanda();
//				d.setId(1L);
//				d.setStatus(Status.Backlog);
//				
//				return Optional.of(d);
//			}
//		});
//		
//		Mockito.when(demandaRepository.save(new Demanda(1L))).then(new Answer<Demanda>() {
//			@Override
//			public Demanda answer(InvocationOnMock invocation) throws Throwable {
//				Demanda d = new Demanda();
//				d.setStatus(Status.Classificado);
//				return d;
//			}
//		});
//		
//		Demanda demandaClassificada = demandaService
//				.classificarDemanda(1L, Tamanho.Pequeno, new Date(2019, 7, 5));
//		
//		Assert.assertEquals("O Status deverá estar como classificado", Status.Classificado, demandaClassificada.getStatus());
	}
	
	@Test(expected = TamanhoObrigatiorException.class)
	public void classificarDemandaSemTamanho() throws Exception {
//		Mockito.when(demandaRepository.findById(1L)).then(new Answer<Optional<Demanda>>() {
//			@Override
//			public Optional<Demanda> answer(InvocationOnMock invocation) throws Throwable {
//				Demanda d = new Demanda();
//				d.setId(1L);
//				d.setStatus(Status.Backlog);
//				
//				return Optional.of(d);
//			}
//		});
//		
//		demandaService.classificarDemanda(1L, null, new Date(2019, 7, 5));
	}
	
}
