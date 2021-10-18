package com.actividad06.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.actividad06.entity.FiltroModalidad;
import com.actividad06.entity.Modalidad;
import com.actividad06.service.ModalidadService;

@RestController
@RequestMapping("/rest/modalidad")
@CrossOrigin(origins = "http://localhost:4200")
public class ModalidadController {

	@Autowired
	private ModalidadService modalidadService;

	// Consulta con envío en formato JSON

	@GetMapping("/porNombreSedeDeporteConJson")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaPorNombreSedeDeporteConParametros(
			@RequestBody FiltroModalidad filtro) {
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			filtro.setNombre("%"+filtro.getNombre()+"%");
			List<Modalidad> lista = modalidadService.listaPorFiltro(filtro);
			if(CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje",  "No existe elementos para la consulta");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Se tiene " + lista.size() + " elementos");
			}
		} catch (Exception e) {
			salida.put("mensaje", "Error : " + e.getMessage());
		}
		return ResponseEntity.ok(salida);
	}

}
