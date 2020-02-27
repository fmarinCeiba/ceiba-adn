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

import com.ceiba.cafe.app.port.in.CreateCategoryUseCase;
import com.ceiba.cafe.app.port.in.DeleteCategoryUseCase;
import com.ceiba.cafe.app.port.in.FindCategoryUseCase;
import com.ceiba.cafe.app.port.in.UpdateCategoryUseCase;
import com.ceiba.cafe.domain.Category;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CategoryController.class)
@TestPropertySource(properties = { "spring.config.location = classpath:application-test.properties" })
public class CategoryControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CreateCategoryUseCase newUnderTest;
	@MockBean
	private FindCategoryUseCase useCaseUnderTest;
	@MockBean
	private UpdateCategoryUseCase updCaseUnderTest;
	@MockBean
	private DeleteCategoryUseCase delCaseUnderTest;

	@Test
	void findCategoryByController() throws Exception {
		mockMvc.perform(
				get("http://localhost:8080/cafe-api/category/{categoryId}", 1L).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());

		then(useCaseUnderTest).should().find(eq(new Long(1L)));
	}

	@Test
	void findAllCategoryByController() throws Exception {
		mockMvc.perform(get("http://localhost:8080/cafe-api/category/").contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());

		then(useCaseUnderTest).should().find(null);
	}

	@Test
	void createCategoryByController() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Category category = Category.withoutId("normal", 2000L, 60L);

		mockMvc.perform(put("http://localhost:8080/cafe-api/category/").content(mapper.writeValueAsString(category))
				.contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isCreated());
	}
}
