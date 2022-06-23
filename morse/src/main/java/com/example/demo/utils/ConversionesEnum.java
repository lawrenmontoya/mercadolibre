package com.example.demo.utils;

public enum ConversionesEnum {

	MORSEATEXTO(1), TEXTOAMORSE(2); //

	private final Integer id;

	private ConversionesEnum(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	/**
	 * Metodo que busca en Status
	 * 
	 * @param status
	 * @return Status
	 */
	public static ConversionesEnum findById(Integer id) {
		if (id != null) {
			for (ConversionesEnum s : values()) {
				if (s.getId().equals(id)) {
					return s;
				}
			}

			throw new IllegalArgumentException(String.format("TIPO ConversionesEnum ID %d NO ENCONTRADO", id));
		} else {
			throw new IllegalArgumentException("TIPO ConversionesEnum ES NULO");
		}
	}

}
