package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.api.ConvertirRestController;
import com.example.demo.dto.MensajeRequestDTO;
import com.example.demo.dto.MensajeRespuestaDTO;
import com.example.demo.service.IConvertirService;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@ContextConfiguration(classes = { ConvertirRestController.class, IConvertirService.class })
@WebMvcTest
class MorseApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	private ConvertirRestController controlador;

	private MensajeRequestDTO mensjaeRequest;
	
	@Autowired
    ObjectMapper objectmapper;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void testHumanCode() throws Exception {
		mensjaeRequest.setMensaje(".... --- .-.. .- -- . .-.. ..");
		MensajeRespuestaDTO resp = new MensajeRespuestaDTO();
		
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/convertir/MorseTexto")
				.content(objectmapper.writeValueAsString(mensjaeRequest))						
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

		String resultDOW = result.getResponse().getContentAsString();
		assertNotNull(resultDOW);
		assertEquals(resp, resultDOW);

	}

}
