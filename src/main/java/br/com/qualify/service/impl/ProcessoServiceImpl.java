package br.com.qualify.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qualify.domain.Processo;
import br.com.qualify.repository.ProcessoRepository;
import br.com.qualify.service.ProcessoService;

@Service
public class ProcessoServiceImpl implements ProcessoService{
	
	@Autowired
	private ProcessoRepository processoRepository;
	
	@Override
	public List<Processo> findAll(){
		return this.processoRepository.findAll();
	}
	
	@Override
	public Processo findById(String codigo) {
		return this.processoRepository.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("Processo não encotnrado"));
	}
	
	
	@Override
	public Processo add(Processo processo){
		
		Processo processoOrigem = this.processoRepository
				.findById(processo.getProcessoOrigem().getCodigo())
				.orElseThrow(() -> new IllegalArgumentException("Processo Origem não encontrado"));
		
		processo.setProcessoOrigem(processoOrigem);
				
		return this.processoRepository.save(processo);
	}
	
	@Override
	public List<Processo> findByComarca(String comarca){
		return  this.processoRepository.getProcessoForComarca(comarca)
				.orElseThrow(() -> new IllegalArgumentException("Processo não encotnrado"));
	}

}
