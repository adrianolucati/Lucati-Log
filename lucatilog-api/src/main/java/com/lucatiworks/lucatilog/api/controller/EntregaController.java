package com.lucatiworks.lucatilog.api.controller;

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

import com.lucatiworks.lucatilog.api.assembler.EntregaAssembler;
import com.lucatiworks.lucatilog.api.model.EntregaModel;
import com.lucatiworks.lucatilog.api.model.input.EntregaInput;
import com.lucatiworks.lucatilog.domain.model.Entrega;
import com.lucatiworks.lucatilog.domain.repository.EntregaRepository;
import com.lucatiworks.lucatilog.domain.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private EntregaRepository entregaRepository;
	private SolicitacaoEntregaService solicitacaoEntregaService;
	private EntregaAssembler entregaAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput) {
		Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
		
		Entrega entregaSolicitada =solicitacaoEntregaService.solicitar(novaEntrega);
		
		return entregaAssembler.toModel(entregaSolicitada);
	}
	
	@GetMapping
	public List<EntregaModel> listar() {
		return entregaAssembler.toCollectionModel(entregaRepository.findAll());
	}
	
	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
		
	}
}



//esse linha de cima substitui todas essas de baixo que est??o comentadas 		
/*EntregaModel entregaModel = new EntregaModel();
entregaModel.setId(entrega.getId());
entregaModel.setNomeCliente(entrega.getCliente().getNome());
entregaModel.setDestinatario(new DestinatarioModel());
entregaModel.getDestinatario().setNome(entrega.getDestinatario().getNome());
entregaModel.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
entregaModel.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
entregaModel.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
entregaModel.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
entregaModel.getDestinatario().setCidade(entrega.getDestinatario().getCidade());
entregaModel.getDestinatario().setUf(entrega.getDestinatario().getUf());
entregaModel.getDestinatario().setCep(entrega.getDestinatario().getCep());
entregaModel.getDestinatario().setFilial(entrega.getDestinatario().getFilial());
entregaModel.setTaxa(entrega.getTaxa());
entregaModel.setStatus(entrega.getStatus());
entregaModel.setDataPedido(entrega.getDataPedido());
entregaModel.setDataFinalizacao(entrega.getDataFinalizacao());
*/