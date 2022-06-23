package com.example.demo.dto;

import java.io.Serializable;

public class MensajeRespuestaDTO implements Serializable {

	private static final long serialVersionUID = 1L;	
	
	private int codigo;
	private String mensajeRespuesta;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}

	@Override
	public String toString() {
		return "MensajeRespuestaDTO [codigo=" + codigo + ", mensajeRespuesta=" + mensajeRespuesta + "]";
	}

}
