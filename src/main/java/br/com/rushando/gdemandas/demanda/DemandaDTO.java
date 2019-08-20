package br.com.rushando.gdemandas.demanda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class DemandaDTO {

    private Long id;
    private String titulo;
    private String descricao;

	public DemandaDTO(Demanda demanda) {
        this.id = demanda.getId();
        this.titulo = demanda.getTitulo();
        this.descricao = demanda.getDescricao();
	}

}