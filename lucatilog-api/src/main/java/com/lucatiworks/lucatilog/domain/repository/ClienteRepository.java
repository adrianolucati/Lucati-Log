package com.lucatiworks.lucatilog.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.lucatiworks.lucatilog.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepositoryImplementation<Cliente, Long> {

	List<Cliente> findByNome(String nome);

	List<Cliente> findByNomeContaining(String nome);
	
	Optional<Cliente> findByEmail(String email);
}
