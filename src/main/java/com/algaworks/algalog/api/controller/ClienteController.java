package com.algaworks.algalog.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("clientes")
public class ClienteController {
		
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> hello() {
		return clienteRepository.findByNomeContaining("a");
	}
	
}
