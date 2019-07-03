package br.com.rushando.gdemandas.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demanda {

	@Id
	@Column(name = "iddemanda")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_demanda")
	@SequenceGenerator(name="seq_demanda", sequenceName="seq_demanda", allocationSize=1)
	private Long id;
	
	private String titulo;
	
	private String descr;
	
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Demanda other = (Demanda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
}
