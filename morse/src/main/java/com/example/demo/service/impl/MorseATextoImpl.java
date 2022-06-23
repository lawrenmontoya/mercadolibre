package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MensajeRequestDTO;
import com.example.demo.service.ITransforma;

@Service
@Primary
public class MorseATextoImpl implements ITransforma {

	private MensajeRequestDTO mensaje;
	
	public MorseATextoImpl() {}
	
	public MorseATextoImpl(MensajeRequestDTO mensaje) {
		this.mensaje=mensaje;
	} 
	
	@Override
	public List<String> transforma() {
		List<String> mensajeConvertido = new ArrayList<String>();
		//.... --- .-.. .- -- . .-.. ..
		mensajeConvertido.addAll(Arrays.asList(mensaje.getMensaje().split(" ")));
		
		for (int i=0 ; i<mensajeConvertido.size() ; i++) 
			if (mensajeConvertido.get(i).isEmpty())
				mensajeConvertido.set(i," ");		
		
		return mensajeConvertido;
	}

}
