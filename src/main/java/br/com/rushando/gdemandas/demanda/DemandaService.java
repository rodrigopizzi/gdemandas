package br.com.rushando.gdemandas.demanda;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rushando.gdemandas.demanda.Demanda.Status;

@Service
@Transactional
public class DemandaService {

	@Autowired
	private DemandaRepository demandaRepository;
	
	public Demanda cadastrar(DemandaDTO dto) {
		Demanda demanda = new Demanda();
		demanda.setDataCadastro(new Date());
		demanda.setDescricao(dto.getDescricao());
		demanda.setTitulo(dto.getTitulo());
		demanda.setStatus(Status.Backlog);

		return demandaRepository.save(demanda);
	}

	public Demanda editar(DemandaDTO dto) {
		Demanda demanda = demandaRepository.findById(dto.getId()).get();
		demanda.setTitulo(dto.getTitulo());
		demanda.setDescricao(dto.getDescricao());
		return demandaRepository.save(demanda);
	}

	public void deletar(Long idDemanda) {
		demandaRepository.deleteById(idDemanda);
	}

	public Demanda classificar(ClassificarDTO dto) throws Exception {
		Demanda demanda = demandaRepository.findById(dto.getId()).get();
		
		if (! demanda.getStatus().equals(Status.Backlog)) {
			throw new Exception("A demanda deve estar com o status Backlog para ser classificada.");
		}
		
		if (dto.getTamanho() == null) {
			throw new Exception("O tamanho não pode ser vazio");
		}

		if (dto.getPrazoOrcamento() == null) {
			throw new Exception("O prazo não pode ser vazio");
		}
		
		demanda.setTamanho(dto.getTamanho());
		demanda.setPrazoOrcamento(dto.getPrazoOrcamento());
		demanda.setStatus(Status.Classificado);
		return demandaRepository.save(demanda);
	}

	public Iterable<Demanda> listAll() {
		return demandaRepository.findAll();
	}

	public DemandaDTO demandaDTOById(Long idDemanda) {
		Demanda demanda = demandaRepository.findById(idDemanda)
			.orElseThrow(() -> new RuntimeException(
				String.format("Demanda não encontrada (%d).", idDemanda))
			);
		return new DemandaDTO(demanda);
	}

	public ClassificarDTO classificarDTOById(Long idDemanda) {
		Demanda demanda = demandaRepository.findById(idDemanda)
			.orElseThrow(() -> new RuntimeException(
				String.format("Demanda não encontrada (%d).", idDemanda))
			);
		return new ClassificarDTO(demanda);
	}

	

	
	
}
