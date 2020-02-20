package com.ceiba.cafe.adapter.web;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.ceiba.cafe.app.port.in.CreateClientUseCase;
import com.ceiba.cafe.app.port.in.DeleteClientUseCase;
import com.ceiba.cafe.app.port.in.FindClientUseCase;
import com.ceiba.cafe.app.port.in.UpdateClientUseCase;
import com.ceiba.cafe.app.port.out.ClientPort;

//@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = ClientController.class)
public class ClientControllerTest {
//	@Autowired
//	private MockMvc mockMvc;

//	@MockBean
//	private ClientPort port;

//	@MockBean
//	private FindClientUseCase useCaseUnderTest(port);
	
//	private final ClientPort clientPort = Mockito.mock(ClientPort.class);
//
//	private final FindClientUseCase useCaseUnderTest = new FindClientUseCase(clientPort);
//	private final CreateClientUseCase newUnderTest = new CreateClientUseCase(clientPort);
//	private final UpdateClientUseCase updCaseUnderTest = new UpdateClientUseCase(clientPort);
//	private final DeleteClientUseCase delCaseUnderTest = new DeleteClientUseCase(clientPort);

	@Test
	void testClient() throws Exception {
//		mockMvc.perform(get("http://localhost:8080/cafe-api/client/{clientId}", 1L)
//				.header("Content-Type", "application/json"))
//				.andExpect(status().isOk());
//
//		then(useCaseUnderTest).should().find(eq(new Long(1L)));
	}
}
