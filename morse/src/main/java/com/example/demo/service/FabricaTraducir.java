package com.example.demo.service;

import org.springframework.stereotype.Component;

import com.example.demo.service.impl.TraducirEspanolaMorseImpl;
import com.example.demo.service.impl.TraducirMorseaTextoImpl;
import com.example.demo.utils.ConversionesEnum;

@Component
public class FabricaTraducir {

	public ITraducir getTraducir(String seleccionar) {
		
		if(seleccionar.equals(ConversionesEnum.MORSEATEXTO.toString())) {
			return new TraducirMorseaTextoImpl();			
		}else if(seleccionar.equals(ConversionesEnum.TEXTOAMORSE.toString() )) {
			return new TraducirEspanolaMorseImpl();
		}
		return null;
		
	}
}
