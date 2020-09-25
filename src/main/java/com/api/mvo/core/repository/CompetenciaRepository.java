package com.api.mvo.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.mvo.core.entity.MaeCompetencia;

/**
 * Interfaz donde se declaran los metodos a usar para el crud con jpa.
 * 
 * @author jcatangu
 * @date: 24/09/2020
 */
@Repository("repositorioCompetencia")
public interface CompetenciaRepository extends JpaRepository<MaeCompetencia, Integer> {

	/**
	 * Metodo para retornar un listado completo de competencias.
	 * 
	 * @author jcatangu
	 * @return Retorna un listado completo de competencias.
	 */
	public List<MaeCompetencia> findAll();

	/**
	 * Metodo para retornar una competencia en especifico.
	 * 
	 * @author jcatangu
	 * @param Recibe el identificador de la competencia.
	 * @return Retorna una competencia en especifico.
	 */
	public MaeCompetencia findByIdCompetencia(Long id);

	/**
	 * Metodo para almacenar una competencia.
	 * @param Recibe un objeto de tipo competencia.
	 * @author jcatangu
	 */
	public <S extends MaeCompetencia> S save(S competencia);

}
