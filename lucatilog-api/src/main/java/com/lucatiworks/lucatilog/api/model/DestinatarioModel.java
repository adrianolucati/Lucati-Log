package com.lucatiworks.lucatilog.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinatarioModel {
	
	private String nome;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	private String filial;

}
