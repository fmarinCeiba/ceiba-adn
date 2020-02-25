package com.ceiba.cafe.adapter.web;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.cafe.app.port.in.CreateClientUseCase;
import com.ceiba.cafe.app.port.in.DeleteClientUseCase;
import com.ceiba.cafe.app.port.in.FindClientUseCase;
import com.ceiba.cafe.app.port.in.UpdateClientUseCase;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ClientController.class)
public class ClientControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CreateClientUseCase newUnderTest;
	@MockBean
	private FindClientUseCase useCaseUnderTest;
	@MockBean
	private UpdateClientUseCase updCaseUnderTest;
	@MockBean
	private DeleteClientUseCase delCaseUnderTest;
	
	@Test
	void findClientByController() throws Exception {
		mockMvc.perform(get("http://localhost:8080/cafe-api/client/{clientId}", 1L)
				.header("Content-Type", "application/json"))
				.andExpect(status().isOk());

		then(useCaseUnderTest).should().find(eq(new Long(1L)));
	}
}
