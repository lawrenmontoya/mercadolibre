package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MensajeRespuestaDTO;
import com.example.demo.service.ITraducir;
import com.example.demo.utils.ICodigos;

@Service
public class TraducirEspanolaMorseImpl implements ITraducir {

	private static final Logger logger = LoggerFactory.getLogger(TraducirEspanolaMorseImpl.class);
	
	public MensajeRespuestaDTO Traducir(List<String> lista) {
		
		MensajeRespuestaDTO respuesta = new  MensajeRespuestaDTO();
		String traducido = "";
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < ICodigos.ESPANOL.length ; i++) {
			map.put(ICodigos.ESPANOL[i], ICodigos.CODIGO_MORSE[i]);
		}		
		
		List<String> listaEspanol = new ArrayList<String>();
		listaEspanol.addAll(Arrays.asList(ICodigos.ESPANOL));
		
		for(String reg : lista) {
			if(listaEspanol.contains(reg)) {
				traducido = traducido.concat(map.get(reg));
			}else {
				respuesta.setMensajeRespuesta("Codigo Espanol no existe");
				respuesta.setCodigo(HttpServletResponse.SC_FORBIDDEN );
				logger.info(respuesta.getMensajeRespuesta());
				return respuesta;
			}			 
		}
		respuesta.setMensajeRespuesta(traducido);
		respuesta.setCodigo(HttpServletResponse.SC_OK);
		
		return respuesta;
		
	}
}
