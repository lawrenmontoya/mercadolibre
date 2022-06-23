package com.example.demo.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MensajeRequestDTO;
import com.example.demo.dto.MensajeRespuestaDTO;
import com.example.demo.service.IConvertirService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/convertir")
public class ConvertirRestController {  

	@Autowired
	private IConvertirService convertirService;

	//HOLA MELI'
	@GetMapping(value="/TextoMorse", produces ={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<MensajeRespuestaDTO > translate2Morse(
			HttpServletRequest req,
			@RequestBody(required = true) MensajeRequestDTO mensajeRequestDTO) {
		MensajeRespuestaDTO respuesta = convertirService.convertir(mensajeRequestDTO, "TEXTOAMORSE");
		if (respuesta.getCodigo() != HttpServletResponse.SC_OK )
			return new ResponseEntity<MensajeRespuestaDTO>(respuesta, HttpStatus.FORBIDDEN);
		
		return new ResponseEntity<MensajeRespuestaDTO>(respuesta, HttpStatus.OK);		
	}
	//.... --- .-.. .- -- . .-.. ..
	@GetMapping(value="/MorseTexto", produces ={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<MensajeRespuestaDTO > translate2Human(
			HttpServletRequest req,
			@RequestBody(required = true) MensajeRequestDTO mensajeRequestDTO) {
		
		MensajeRespuestaDTO respuesta = convertirService.convertir(mensajeRequestDTO, "MORSEATEXTO");
		if (respuesta.getCodigo() != HttpServletResponse.SC_OK )
			return new ResponseEntity<MensajeRespuestaDTO>(respuesta, HttpStatus.FORBIDDEN);
		
		return new ResponseEntity<MensajeRespuestaDTO>(respuesta, HttpStatus.OK);
	}

}
