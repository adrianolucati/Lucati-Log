package com.lucatiworks.lucatilog.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucatiworks.lucatilog.domain.exception.NegocioException;
import com.lucatiworks.lucatilog.domain.model.Cliente;
import com.lucatiworks.lucatilog.domain.model.Entrega;
import com.lucatiworks.lucatilog.domain.model.StatusEntrega;
import com.lucatiworks.lucatilog.domain.repository.ClienteRepository;
import com.lucatiworks.lucatilog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
	
	private CatalogoClienteService catalogoClienteService;
	private EntregaRepository entregaRepository;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		
		return entregaRepository.save(entrega);
	}
}
