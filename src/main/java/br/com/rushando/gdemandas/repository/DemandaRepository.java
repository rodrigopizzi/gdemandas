package br.com.rushando.gdemandas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rushando.gdemandas.domain.Demanda;

@Repository
public interface DemandaRepository extends CrudRepository<Demanda, Long> {

}
