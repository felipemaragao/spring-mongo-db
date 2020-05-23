package br.com.qualify.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.qualify.domain.Processo;

public interface ProcessoRepository extends MongoRepository<Processo, String>{
	
	@Query("{'comarca': { $eq: ?0 }}")
	public List<Processo> getProcessoForComarca(String comarca);
	
	public List<Processo> findByComarca(String comarca);

}
