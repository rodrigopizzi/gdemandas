package br.com.rushando.gdemandas.demanda;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rushando.gdemandas.demanda.Demanda.Status;
import br.com.rushando.gdemandas.demanda.Demanda.Tamanho;
import br.com.rushando.gdemandas.demanda.Demanda.TamanhoObrigatiorException;

@Service
@Transactional
public class DemandaService {

	@Autowired
	private DemandaRepository demandaRepository;
	
	public Demanda cadastrar(DemandaDTO demanda) {
		Demanda d = new Demanda();
		d.setDataCadastro(new Date());
		d.setDescricao(demanda.getDescricao());
		d.setTitulo(demanda.getTitulo());
		d.setStatus(Status.Backlog);

		return demandaRepository.save(d);
	}

	public Demanda editar(DemandaDTO demanda) {
		Demanda d = demandaRepository.findById(demanda.getId()).get();
		d.setTitulo(demanda.getTitulo());
		d.setDescricao(demanda.getDescricao());
		return demandaRepository.save(d);
	}

	public void deletar(Long idDemanda) {
		demandaRepository.deleteById(idDemanda);
	}

	public Demanda classificar(Long idDemanda, Tamanho tamanho, Date prazoOrcamento) throws Exception {
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

	public DemandaDTO demandaDTOById(Long idDemanda) {
		Demanda d = demandaRepository.findById(idDemanda)
			.orElseThrow(() -> new RuntimeException(
				String.format("Demanda não encontrada (%d).", idDemanda))
			);
		return new DemandaDTO(d);
	}

	public ClassificarDTO classificarDTOById(Long idDemanda) {
		Demanda d = demandaRepository.findById(idDemanda)
			.orElseThrow(() -> new RuntimeException(
				String.format("Demanda não encontrada (%d).", idDemanda))
			);
		return new ClassificarDTO(d);
	}

	

	
	
}
