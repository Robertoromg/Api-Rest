package com.conta.apirest.resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.conta.apirest.models.Conta;
import com.conta.apirest.repository.ContaRepository;

@RestController
@RequestMapping(value="/api")
public class ContaResources {
	
	@Autowired
	ContaRepository contaRepository;
	
	@GetMapping("/contas")
	public List<Conta> listaContas(){
		return contaRepository.findAll();
	}
	
	@GetMapping("/contas/{id}")
	public Conta listaContaUnica(@PathVariable(value="id")long id){
		return contaRepository.findById(id);
	}
}