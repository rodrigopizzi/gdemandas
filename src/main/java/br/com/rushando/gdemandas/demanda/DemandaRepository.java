package br.com.rushando.gdemandas.demanda;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface DemandaRepository extends CrudRepository<Demanda, Long> {

}
