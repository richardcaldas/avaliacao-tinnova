package com.tinnova.avaliacao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinnova.avaliacao.exercicio5.model.Veiculo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class AvaliacaoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
    private ObjectMapper objectMapper;


	@Test
	void caseGetVeiculos() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders
				.get("/veiculos")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
			
	}

	@Test
	void caseGetVeiculosById() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders
				.get("/veiculos/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
			
	}

	@Test
	void caseCreateVeiculos() throws Exception {

		final Veiculo veiculo = new Veiculo();
		veiculo.setVeiculo("teste");
		veiculo.setMarca("Ford");
		veiculo.setAno(2020);
		veiculo.setDescricao("descricao");
		veiculo.setVendido(false);

		mockMvc.perform(MockMvcRequestBuilders
				.post("/veiculos")
				.content(objectMapper.writeValueAsString(veiculo))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
			
	}

	@Test
	void caseCreateVeiculosWithMarcaInvalida() throws Exception {

		final Veiculo veiculo = new Veiculo();
		veiculo.setVeiculo("teste");
		veiculo.setMarca("teste");
		veiculo.setAno(2020);
		veiculo.setDescricao("descricao");
		veiculo.setVendido(false);

		mockMvc.perform(MockMvcRequestBuilders
				.post("/veiculos")
				.content(objectMapper.writeValueAsString(veiculo))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
			
	}

	@Test
	void caseUpdateVeiculos() throws Exception {

		final Veiculo veiculo = new Veiculo();
		veiculo.setVeiculo("teste");
		veiculo.setMarca("Ford");
		veiculo.setAno(2020);
		veiculo.setDescricao("descricao");
		veiculo.setVendido(false);

		mockMvc.perform(MockMvcRequestBuilders
				.put("/veiculos/{id}",12)
				.content(objectMapper.writeValueAsString(veiculo))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
			
	}

	@Test
	void caseDeleteVeiculo() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders
				.delete("/veiculos/{id}",16))
				.andExpect(MockMvcResultMatchers.status().isOk());			
	}

	@Test
	void caseDeleteVeiculoIsNotFound() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders
				.delete("/veiculos/{id}",1))
				.andExpect(MockMvcResultMatchers.status().isNotFound());			
	}

}
