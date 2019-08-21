package br.com.rushando.gdemandas.demanda;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.rushando.gdemandas.demanda.Demanda.Tamanho;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class ClassificarDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private Tamanho tamanho;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prazoOrcamento;

    public ClassificarDTO(Demanda demanda) {
        this.id = demanda.getId();
        this.titulo = demanda.getTitulo();
        this.descricao = demanda.getDescricao();
        this.tamanho = demanda.getTamanho();
        this.prazoOrcamento = demanda.getPrazoOrcamento();
	}

}