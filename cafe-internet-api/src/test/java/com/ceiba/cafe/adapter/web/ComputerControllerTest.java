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

import com.ceiba.cafe.app.port.in.CreateComputerUseCase;
import com.ceiba.cafe.app.port.in.DeleteComputerUseCase;
import com.ceiba.cafe.app.port.in.FindComputerUseCase;
import com.ceiba.cafe.app.port.in.UpdateComputerUseCase;
import com.ceiba.cafe.domain.Computer;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ComputerController.class)
@TestPropertySource(properties = { "spring.config.location = classpath:application-test.properties" })
public class ComputerControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CreateComputerUseCase newUnderTest;
	@MockBean
	private FindComputerUseCase useCaseUnderTest;
	@MockBean
	private UpdateComputerUseCase updCaseUnderTest;
	@MockBean
	private DeleteComputerUseCase delCaseUnderTest;

	@Test
	void findComputerByController() throws Exception {
		mockMvc.perform(
				get("http://localhost:8080/cafe-api/computer/{statusId}", 1L).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());

		then(useCaseUnderTest).should().find(eq(new Long(1L)));
	}

	@Test
	void findAllComputerByController() throws Exception {
		mockMvc.perform(get("http://localhost:8080/cafe-api/computer/").contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());

		then(useCaseUnderTest).should().find(null);
	}

	@Test
	void createComputerByController() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Computer computer = Computer.withoutId("Gamer1", 1L, 2L, "192.168.100.110", "fe80::e554:b521:ee60:e1c9#9",
				"cuarto 1");

		mockMvc.perform(put("http://localhost:8080/cafe-api/computer/").content(mapper.writeValueAsString(computer))
				.contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
	}
}
