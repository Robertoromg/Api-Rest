package com.conta.apirest.resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conta.apirest.models.Conta;
import com.conta.apirest.repository.ContaRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api("Api Rest contas")
@CrossOrigin(origins="*")
public class ContaResources {
	
	@Autowired
	ContaRepository contaRepository;
	
	@GetMapping("/contas")
	@ApiOperation(value="Retorna uma lista com as contas validadas")
	public List<Conta> listaContas(){
		return contaRepository.findAll();
	}
	
	@GetMapping("/contas/{id}")
	@ApiOperation(value="Retorna conta deteminada pelo id")
	public Conta listaContaUnica(@PathVariable(value="id")long id){
		return contaRepository.findById(id);
	}
	
	@PostMapping("/contas")
	@ApiOperation(value="Salva uma conta criada")
	public Conta salvaConta(@RequestBody Conta conta) {
		return contaRepository.save(conta);
	}
	
	@DeleteMapping("/contas")
	@ApiOperation(value="exclui uma conta ")
	public void deletaConta(@RequestBody Conta conta) {
		contaRepository.delete(conta);
	}
	
	@PutMapping("/contas")
	@ApiOperation(value="Atualiza dados de uma conta")
	public Conta atualizaConta(@RequestBody Conta conta) {
		return contaRepository.save(conta);
	}
}
