package br.com.qualify.service;

import java.util.List;

import br.com.qualify.domain.Processo;

public interface ProcessoService {

	List<Processo> findAll();

	Processo findById(String codigo);

	Processo add(Processo processo);

	List<Processo> findByComarca(String comarca);

}
