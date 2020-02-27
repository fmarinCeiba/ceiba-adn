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

import com.ceiba.cafe.app.port.in.CalculateRentUseCase;
import com.ceiba.cafe.app.port.in.CreateRentUseCase;
import com.ceiba.cafe.app.port.in.FindRentUseCase;
import com.ceiba.cafe.app.port.in.UpdateRentUseCase;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = RentController.class)
@TestPropertySource(properties = { "spring.config.location = classpath:application-test.properties" })
public class RentControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CreateRentUseCase newUnderTest;
	@MockBean
	private FindRentUseCase useCaseUnderTest;
	@MockBean
	private UpdateRentUseCase updCaseUnderTest;
	@MockBean
	private CalculateRentUseCase calCaseUnderTest;

	@Test
	void findRentByController() throws Exception {
		mockMvc.perform(get("http://localhost:8080/cafe-api/rent/{rentId}", 1L).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());

		then(useCaseUnderTest).should().find(eq(new Long(1L)));
	}

	@Test
	void findAllRentByController() throws Exception {
		mockMvc.perform(get("http://localhost:8080/cafe-api/rent/").contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());

		then(useCaseUnderTest).should().find(null);
	}

//	@Test
//	void createRentByController() throws Exception {
//		ObjectMapper mapper = new ObjectMapper();
//		RentCommand rentCmd = new RentCommand(0L, 1L, 1L, true, LocalDateTime.now(), LocalDateTime.now());
//
//		mockMvc.perform(put("http://localhost:8080/cafe-api/rent/").content(mapper.writeValueAsString(rentCmd))
//				.contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
//
//		then(newUnderTest).should().create(rentCmd);
//	}
//
//	@Test
//	void updateRentByController() throws Exception {
//		ObjectMapper mapper = new ObjectMapper();
//		RentCommand rentCmd = new RentCommand(1L, 1L, 1L, true, LocalDateTime.now(), LocalDateTime.now());
//
//		mockMvc.perform(post("http://localhost:8080/cafe-api/rent/").content(mapper.writeValueAsString(rentCmd))
//				.contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
//
//		then(updCaseUnderTest).should().update(rentCmd);
//	}
}
