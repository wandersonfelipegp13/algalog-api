package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping
	public List<Cliente> hello() {
		return entityManager.createQuery("from Cliente", Cliente.class)
				.getResultList();
	}
	
}
