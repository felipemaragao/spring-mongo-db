package br.com.qualify.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Processo {
	
	@Id
	private String codigo;
	private String comarca;
	private String tipoAcao;
	private String resumo;
	
	@DBRef
	private Processo processoOrigem;

}
