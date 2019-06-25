package br.com.rushando.gdemandas.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rushando.gdemandas.domain.Demanda;
import br.com.rushando.gdemandas.domain.Demanda.CadastroInvalidoException;
import br.com.rushando.gdemandas.domain.Demanda.Status;
import br.com.rushando.gdemandas.repository.DemandaRepository;

@Service
public class DemandaService {

	@Autowired
	private DemandaRepository demandaRepository;
	
	@Transactional
	public void cadastrarDemanda(Demanda demanda) throws CadastroInvalidoException {
		if (! demanda.getStatus().equals(Status.Backlog)) {
			throw new CadastroInvalidoException();
		}
		
		demandaRepository.save(demanda);
	}
	
}
