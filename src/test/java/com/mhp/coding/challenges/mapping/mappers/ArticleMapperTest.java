package com.mhp.coding.challenges.mapping.mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;

public class ArticleMapperTest {

	@Test
	public void testBasicMapping() {
		Article article = new Article();
		article.setId(1432L);
		ArticleMapper mapper = new ArticleMapper();
		ArticleDto articleDto = mapper.map(article);
		assertEquals(new Long(1432), articleDto.getId());
	}

	@Test
	public void testNullArticle() {
		Article article = null;
		ArticleMapper mapper = new ArticleMapper();
		ArticleDto articleDto = mapper.map(article);
		assertNull(articleDto);
	}
}
