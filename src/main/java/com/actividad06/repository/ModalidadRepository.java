package com.actividad06.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.actividad06.entity.FiltroModalidad;
import com.actividad06.entity.Modalidad;

public interface ModalidadRepository extends JpaRepository<Modalidad, Integer> {
	
	@Query("select m from Modalidad m where "
			+ "( :#{#fil.nombre} is '' or m.nombre like :#{#fil.nombre}) and "
			+ "( :#{#fil.sede} is '' or m.sede like :#{#fil.sede}) and "
			+ "( :#{#fil.idDeporte} is 0 or m.deporte.idDeporte = :#{#fil.idDeporte} )")
	public abstract List<Modalidad> listaPorFiltro(@Param("fil")FiltroModalidad filtro);
}
