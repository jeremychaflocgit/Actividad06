package com.actividad06.service;

import java.util.List;

import com.actividad06.entity.FiltroModalidad;
import com.actividad06.entity.Modalidad;

public interface ModalidadService {
	
	public abstract List<Modalidad> listaPorFiltro(FiltroModalidad filtro);
}
