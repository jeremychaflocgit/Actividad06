package com.actividad06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.actividad06.entity.FiltroModalidad;
import com.actividad06.entity.Modalidad;
import com.actividad06.repository.ModalidadRepository;

@Service
public class ModalidadServiceImpl implements ModalidadService{

	@Autowired
	private ModalidadRepository repositorio;

	@Override
	public List<Modalidad> listaPorFiltro(FiltroModalidad filtro) {
		return repositorio.findAll();
	}
	

}
