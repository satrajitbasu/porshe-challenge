package com.mhp.coding.challenges.mapping.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mhp.coding.challenges.mapping.services.ArticleService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ArticleController.class, secure = false)
public class ArticleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ArticleService articleService;

	@Test
	public void testArticleNotFoundException() throws Exception {
		Mockito.when(articleService.articleForId(Mockito.anyLong()))
				.thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/article/1001").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(404, result.getResponse().getStatus());
	}

}
