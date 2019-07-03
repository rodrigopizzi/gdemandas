package br.com.rushando.gdemandas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.rushando.gdemandas.services.demanda.CadastrarDemandaTests;
import br.com.rushando.gdemandas.services.demanda.CancelarDemandaTests;
import br.com.rushando.gdemandas.services.demanda.ClassificarDemandaTests;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CadastrarDemandaTests.class,
        ClassificarDemandaTests.class,
        CancelarDemandaTests.class
})
public class DemandaServiceTests {
	
}
