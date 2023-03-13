package com.algaworks.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	@GetMapping
	public List<Cliente> hello() {
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("João");
		cliente1.setEmail("joão@mail.com");
		cliente1.setTelefone("(83) 32899887");
		
		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("José");
		cliente2.setEmail("jose@mail.com");
		cliente2.setTelefone("(34) 81928321");
		
		return Arrays.asList(cliente1, cliente2);
	}
	
}
