package com.lucatiworks.lucatilog.domain.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.lucatiworks.lucatilog.domain.model.Entrega;

@Repository
public interface EntregaRepository extends JpaRepositoryImplementation<Entrega, Long>{

}
