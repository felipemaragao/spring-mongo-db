package br.com.qualify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.qualify.domain.Processo;
import br.com.qualify.service.ProcessoService;


@RestController
@RequestMapping("/processos")
public class ProcessoController {
	
	
	@Autowired
	private ProcessoService processoService;
		
	
	@GetMapping
	public List<Processo> findAll(){

		return this.processoService.findAll();
	}


	@GetMapping("/{codigo}")
	public ResponseEntity<Processo> findById(@PathVariable("codigo") String codigo){

		try {
			return ResponseEntity.status(HttpStatus.CREATED)
				.body(this.processoService.findById(codigo));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
	@GetMapping("/comarca/{comarca}")
	public List<Processo> findByComarca(@PathVariable("comarca") String comarca){

		return this.processoService.findByComarca(comarca);
	}

	@PostMapping
	public ResponseEntity<Processo> add(@RequestBody Processo processo){

		try {
			return ResponseEntity.status(HttpStatus.CREATED)
				.body(this.processoService.add(processo));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
