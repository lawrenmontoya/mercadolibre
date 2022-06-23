package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.MensajeRequestDTO;
import com.example.demo.service.ITransforma;

@Service
public class TextoAMorseImpl implements ITransforma {

	private MensajeRequestDTO mensaje;
	
	public TextoAMorseImpl() {}
	public TextoAMorseImpl(MensajeRequestDTO mensaje) {
		this.mensaje = mensaje;
	}	
	
	@Override
	public List<String> transforma() {
		List<String> mensajeConvertido = new ArrayList<String>();
		mensajeConvertido.addAll(Arrays.asList(mensaje.getMensaje().split("")));		
		return mensajeConvertido; 
	}

}
