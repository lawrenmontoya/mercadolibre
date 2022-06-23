package com.example.demo.service;

import org.springframework.stereotype.Component;

import com.example.demo.dto.MensajeRequestDTO;
import com.example.demo.service.impl.MorseATextoImpl;
import com.example.demo.service.impl.TextoAMorseImpl;
import com.example.demo.utils.ConversionesEnum;

@Component
public class FabricaConvertir {

	public ITransforma getConvertir(MensajeRequestDTO mensajeRequestDTO, String seleccionar) {
		
		if(seleccionar.equals(ConversionesEnum.MORSEATEXTO.toString())) {
			return new MorseATextoImpl(mensajeRequestDTO);
		}else if(seleccionar.equals(ConversionesEnum.TEXTOAMORSE.toString() )) {
			return new TextoAMorseImpl(mensajeRequestDTO);
		}
		return null;
		
	}
}
