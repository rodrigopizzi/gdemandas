package br.com.rushando.gdemandas.demanda;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
class Demanda {

	@Id
	@Column(name = "iddemanda")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_demanda")
	@SequenceGenerator(name="seq_demanda", sequenceName="seq_demanda", allocationSize=1)
	private Long id;
	
	private String titulo;
	
	private String descricao;
	
	private Status status;
	
	private Long idcliente;
	
	private Date dataCadastro;
	
	private Tamanho tamanho;
	
	private Date prazoOrcamento;
	
	public Demanda(long id) {
		this.id = id;
	}
	
	public static enum Status {
		Backlog, Classificado
	}
	
	public static enum Tamanho {
		Pequeno, Medio, Grande, Enorme 
	}
	
	public static class TamanhoObrigatiorException extends Exception {
		private static final long serialVersionUID = 1L;

		public TamanhoObrigatiorException(String string) {
			super(string);
		}
	}	
	
}