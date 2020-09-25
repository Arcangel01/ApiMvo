package com.api.mvo.core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.mvo.core.entity.MaeConocimientoMedir;

/**
 * Interfaz donde se declaran los metodos a usar para el crud con jpa.
 * 
 * @author jcatangu
 * @date: 24/09/2020
 */
@Repository("repositorioConocimientoMedir")
public interface ConocimientoMedirRepository extends JpaRepository<MaeConocimientoMedir, Integer> {

	/**
	 * Metodo para retornar un listado completo de conocimiento a medir.
	 * 
	 * @author jcatangu
	 * @return Retorna un listado completo de conocimiento a medir.
	 */
	public List<MaeConocimientoMedir> findAll();

	/**
	 * Metodo para retornar un conocimiento a medir en especifico.
	 * 
	 * @author jcatangu
	 * @param Recibe el identificador del conocimiento a medir.
	 * @return Retorna un conocimiento a medir en especifico.
	 */
	public MaeConocimientoMedir findByIdConocimientoMedir(Long id);

	/**
	 * Metodo para almacenar un conocimiento a medir.
	 * @param Recibe un objeto de tipo cconocimiento a medir.
	 * @author jcatangu
	 */
	public <S extends MaeConocimientoMedir> S save(S conocimientoMedir);
}
