package com.api.mvo.core.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.mvo.core.dto.MaestroDto;
import com.api.mvo.core.entity.Dtomaestro;

@Repository("repoDto")
public interface DtoMaestroRepository extends JpaRepository<Dtomaestro, Integer> {
	
	public List<Dtomaestro> findAll();
	
	public Dtomaestro findByIdmaestro(BigDecimal id);
	
	public <S extends Dtomaestro> S save(S dtomaestro);
	
}
