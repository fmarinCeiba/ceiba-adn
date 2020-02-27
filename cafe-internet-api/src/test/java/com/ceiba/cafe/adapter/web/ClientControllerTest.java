package com.ceiba.cafe.adapter.web;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.cafe.app.port.in.CreateClientUseCase;
import com.ceiba.cafe.app.port.in.DeleteClientUseCase;
import com.ceiba.cafe.app.port.in.FindClientUseCase;
import com.ceiba.cafe.app.port.in.UpdateClientUseCase;
import com.ceiba.cafe.domain.Client;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ClientController.class)
@TestPropertySource(properties = { "spring.config.location = classpath:application-test.properties" })
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

//	@Transactional
//	@Rollback(true)
//	@Test
//	@SqlGroup({
//			@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:integration/beforeclientsave.sql"),
//			@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:integration/afterclientsave.sql") })
//	public void getClientTest() throws Exception {
//		mockMvc.perform(
//				get("http://localhost:8080/cafe-api/client/{clientId}", 1L).contentType(MediaType.APPLICATION_JSON))
//				.andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("name", equalTo("francisco")))
//				.andExpect(jsonPath("identification", equalTo("703045")));
//	}

	@Test
	void findClientByController() throws Exception {
		mockMvc.perform(
				get("http://localhost:8080/cafe-api/client/{clientId}", 1L).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());

		then(useCaseUnderTest).should().find(eq(new Long(1L)));
	}

	@Test
	void findAllClientByController() throws Exception {
		mockMvc.perform(get("http://localhost:8080/cafe-api/client/").contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());

		then(useCaseUnderTest).should().find(null);
	}

	@Test
	void createClientByController() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Client client = Client.withoutId("francisco", "703045");

		mockMvc.perform(put("http://localhost:8080/cafe-api/client/").content(mapper.writeValueAsString(client))
				.contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
	}
}
