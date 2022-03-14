package com.lucatiworks.lucatilog.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Destinatario {
	
	@NotBlank
	@Column (name = "destinatario_nome")
	private String nome;

	@NotBlank
	@Column (name = "destinatario_logradouro")
	private String logradouro;

	@NotBlank
	@Column (name = "destinatario_numero")
	private String numero;

	@NotBlank
	@Column (name = "destinatario_complemento")
	private String complemento;

	@NotBlank
	@Column (name = "destinatario_bairro")
	private String bairro;

	@NotBlank
	@Column (name = "destinatario_cidade")
	private String cidade;

	@NotBlank
	@Column (name = "destinatario_uf")
	private String uf;
	
	@Column (name = "destinatario_cep")
	private String cep;
	
	@Column (name = "destinatario_filial")
	private String filial;

}
