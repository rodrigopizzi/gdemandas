package br.com.rushando.gdemandas.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rushando.gdemandas.domain.Demanda;
import br.com.rushando.gdemandas.domain.Demanda.Status;
import br.com.rushando.gdemandas.domain.Demanda.Tamanho;
import br.com.rushando.gdemandas.domain.Demanda.TamanhoObrigatiorException;
import br.com.rushando.gdemandas.repository.DemandaRepository;

@Service
public class DemandaService {

	@Autowired
	private DemandaRepository demandaRepository;
	
	@Transactional
	public Demanda cadastrarDemanda(Demanda demanda) {
		return demandaRepository.save(demanda);
	}

	@Transactional
	public Demanda classificarDemanda(Long idDemanda, Tamanho tamanho, Date prazoOrcamento) throws Exception {
		Demanda demanda = demandaRepository.findById(idDemanda).get();
		
		if (! demanda.getStatus().equals(Status.Backlog)) {
			throw new Exception("A demanda deve estar com o status Backlog para ser classificada.");
		}
		
		if (tamanho == null) {
			throw new TamanhoObrigatiorException("O tamanho não pode ser vazio");
		}
		
		demanda.setTamanho(tamanho);
		demanda.setPrazoOrcamento(prazoOrcamento);
		return demandaRepository.save(demanda);
	}
	
}
