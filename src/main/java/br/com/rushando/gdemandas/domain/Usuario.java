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
public class Usuario {

	@Id
	@Column(name = "idusuario")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_usuario")
	@SequenceGenerator(name="seq_usuario", sequenceName="seq_usuario", allocationSize=1)
	private Long id;
	
	private String email;
	
	private String senha;

}
