package com.actividad06.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.actividad06.entity.Deporte;
import com.actividad06.repository.DeporteRepository;

@Service
public class DeporteServiceImpl implements DeporteService {

	@Autowired
	private DeporteRepository repositorio;
	
	@Override
	public List<Deporte> listaDeporte() {
		
		return repositorio.findAll();
	}

}
