package br.com.rushando.gdemandas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Cliente {

	@Id
	@Column(name = "idcliente")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_cliente")
	@SequenceGenerator(name="seq_cliente", sequenceName="seq_cliente", allocationSize=1)
	private Long id;
	
	private String nome;
	
}
