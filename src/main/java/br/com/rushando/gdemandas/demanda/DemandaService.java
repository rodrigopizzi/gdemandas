package br.com.rushando.gdemandas.demanda;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rushando.gdemandas.demanda.Demanda.Status;
import br.com.rushando.gdemandas.demanda.Demanda.Tamanho;
import br.com.rushando.gdemandas.demanda.Demanda.TamanhoObrigatiorException;

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

	public Iterable<Demanda> listAll() {
		return demandaRepository.findAll();
	}
	
}
