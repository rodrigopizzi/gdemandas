package br.com.rushando.gdemandas.domain;

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
	
	public static enum Status {
		Backlog, Classificado
	}
	
	public static class CadastroInvalidoException extends Exception {
		public CadastroInvalidoException() {
			super("A demanda deve ser cadastrada com o status Backlog");
		}

		private static final long serialVersionUID = 1L;
	}

}
