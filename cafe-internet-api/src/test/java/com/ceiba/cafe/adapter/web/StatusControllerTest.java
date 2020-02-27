package com.ceiba.cafe.adapter.web;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.ceiba.cafe.app.port.in.FindStatusUseCase;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = StatusController.class)
@TestPropertySource(properties = { "spring.config.location = classpath:application-test.properties" })
public class StatusControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FindStatusUseCase useCaseUnderTest;

	@Test
	void findStatusByController() throws Exception {
		mockMvc.perform(
				get("http://localhost:8080/cafe-api/status/{statusId}", 1L).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());

		then(useCaseUnderTest).should().find(eq(new Long(1L)));
	}

	@Test
	void findAllStatusByController() throws Exception {
		mockMvc.perform(get("http://localhost:8080/cafe-api/status/").contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());

		then(useCaseUnderTest).should().find(null);
	}
}
