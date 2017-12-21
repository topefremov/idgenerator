package org.efremov.idgenerator.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.BDDMockito.given;

import org.efremov.idgenerator.service.IdGeneratorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(GeneratorController.class)
public class GeneratorControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private IdGeneratorService idGeneratorService;
	
	@Test
	public void getRandomMultiplicationTest() throws Exception {
		// given
		given(idGeneratorService.generateId()).willReturn("123");
		
		// when
		MockHttpServletResponse response = mvc.perform(post("/id")
					.accept(MediaType.APPLICATION_JSON))
				.andReturn().getResponse();
		
		// then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		System.out.println(response.getContentAsString());
		assertThat(response.getContentAsString()).isEqualTo("123");
	}
}

