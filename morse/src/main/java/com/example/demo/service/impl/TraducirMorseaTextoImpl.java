package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MensajeRespuestaDTO;
import com.example.demo.service.ITraducir;
import com.example.demo.utils.ICodigos;

@Service
@Primary
public class TraducirMorseaTextoImpl implements ITraducir {

	private static final Logger logger = LoggerFactory.getLogger(TraducirEspanolaMorseImpl.class);
	
	public MensajeRespuestaDTO Traducir(List<String> lista) {
	
		MensajeRespuestaDTO respuesta = new  MensajeRespuestaDTO();
		String traducido = "";
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < ICodigos.CODIGO_MORSE.length ; i++) {
			map.put(ICodigos.CODIGO_MORSE[i], ICodigos.ESPANOL[i]);
		}		
		
		List<String> listaMorse = new ArrayList<String>();
		listaMorse.addAll(Arrays.asList(ICodigos.CODIGO_MORSE));
		
		for(String reg : lista) {
			if(listaMorse.contains(reg)) {
				traducido = traducido.concat(map.get(reg));
			}else {				
				respuesta.setMensajeRespuesta("Codigo Morse no existe");
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
