package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.model.DestinatarioModel;
import com.algaworks.algalog.api.model.EntregaModel;
import com.algaworks.algalog.domain.model.Destinatario;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("entregas")
public class EntregaController {

	private SolicitacaoEntregaService solicitacaoEntregaService;
	private EntregaRepository entregaRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
		return solicitacaoEntregaService.solicitar(entrega);
	}

	@GetMapping
	public List<Entrega> listar() {
		return entregaRepository.findAll();
	}

	@GetMapping("{entregaId}")
	public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId).map(entrega -> {

			EntregaModel entregaModel = new EntregaModel();
			entregaModel.setId(entrega.getId());
			entregaModel.setNomeCliente(entrega.getCliente().getNome());

			DestinatarioModel destinatarioModel = new DestinatarioModel();
			Destinatario destinatario = entrega.getDestinatario();

			destinatarioModel.setNome(destinatario.getNome());
			destinatarioModel.setBairro(destinatario.getBairro());
			destinatarioModel.setComplemento(destinatario.getComplemento());
			destinatarioModel.setLogradouro(destinatario.getLogradouro());
			destinatarioModel.setNumero(destinatario.getNumero());

			entregaModel.setDestinatario(destinatarioModel);

			entregaModel.setTaxa(entrega.getTaxa());
			entregaModel.setStatus(entrega.getStatus());
			entregaModel.setDataPedido(entrega.getDataPedido());
			entregaModel.setDataFinalizacao(entrega.getDataFinalizacao());
			
			return ResponseEntity.ok(entregaModel);

		}).orElse(ResponseEntity.notFound().build());
	}

}
