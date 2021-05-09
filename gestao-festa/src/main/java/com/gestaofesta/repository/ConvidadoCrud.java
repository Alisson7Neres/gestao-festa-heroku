package com.gestaofesta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaofesta.model.Convidado;

public interface ConvidadoCrud  extends JpaRepository<Convidado, Long>{

}
