package com.api.mvo.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.mvo.core.entity.MaeAreaConocimiento;

/**
 * Interfaz donde se declaran los metodos a usar para el crud.
 * 
 * @author jcatangu
 * @date: 24/09/2020
 */
@Repository("repositoryAreaConocimiento")
public interface AreaConocimientoRepository extends JpaRepository<MaeAreaConocimiento, Integer> {

	/**
	 * Metodo para retornar un listado completo de area de conocimiento.
	 * 
	 * @author jcatangu
	 * @return Retorna un listado completo de area de conocimiento.
	 */
	public List<MaeAreaConocimiento> findAll();

	/**
	 * Metodo para retornar una area de conocimiento en especifico.
	 * 
	 * @author jcatangu
	 * @param Recibe el identificador del area de conocimiento.
	 * @return Retornar una area de conocimiento en especifico.
	 */
	public MaeAreaConocimiento findByIdAreaConocimiento(Long id);

	/**
	 * Metodo para almacenar un area de conociminetos.
	 * 
	 * @author jcatangu
	 */
	public <S extends MaeAreaConocimiento> S save(S areaConocimiento);
}
