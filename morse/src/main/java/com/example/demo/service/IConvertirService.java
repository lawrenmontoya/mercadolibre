package com.example.demo.service;

import com.example.demo.dto.MensajeRequestDTO;
import com.example.demo.dto.MensajeRespuestaDTO;

public interface IConvertirService {
	public MensajeRespuestaDTO convertir (MensajeRequestDTO MensajeRequestDTO, String seleccionar);
}
