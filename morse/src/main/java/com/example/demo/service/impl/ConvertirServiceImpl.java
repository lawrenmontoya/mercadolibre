package com.example.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.MensajeRequestDTO;
import com.example.demo.dto.MensajeRespuestaDTO;
import com.example.demo.service.FabricaConvertir;
import com.example.demo.service.FabricaTraducir;
import com.example.demo.service.ITransforma;
import com.example.demo.service.IConvertirService;
import com.example.demo.service.ITraducir;


@Service
public class ConvertirServiceImpl implements IConvertirService {

	private static final Logger logger = LoggerFactory.getLogger(ConvertirServiceImpl.class);
	
	@Autowired
	private FabricaConvertir fabricaConvertir;
	
	@Autowired
	private FabricaTraducir fabricaTraducir; 
	
	@Autowired
	private ITransforma iTransforma;
	
	@Autowired
	private ITraducir iTraducir;
	
	@Override
	public MensajeRespuestaDTO convertir(MensajeRequestDTO mensajeRequestDTO, String seleccionar) {		
		
		logger.info("Inicia Proceso de conversion");
		
		iTransforma =  fabricaConvertir.getConvertir(mensajeRequestDTO, seleccionar);
		
		List<String> result = iTransforma.transforma();
		
		iTraducir = fabricaTraducir.getTraducir(seleccionar);				
		
		logger.info("Finaliza Proceso de conversion");
		
		return iTraducir.Traducir(result); 
	}

}
