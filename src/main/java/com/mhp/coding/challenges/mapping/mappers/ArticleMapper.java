package com.mhp.coding.challenges.mapping.mappers;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;

@Component
public class ArticleMapper {

	public ArticleDto map(Article article) {
		ArticleMappingProvider mappingProvider = Mappers
				.getMapper(ArticleMappingProvider.class);
		ArticleDto articleDto = mappingProvider.articleToArticleDto(article);

		try {
			if (!StringUtils.isEmpty(articleDto)
					&& !StringUtils.isEmpty(articleDto.getBlocks())) {
				Collection<ArticleBlockDto> sortedArticleBlocks = articleDto
						.getBlocks()
						.stream()
						.sorted(Comparator
								.comparingInt(ArticleBlockDto::getSortIndex))
						.collect(Collectors.toList());
				articleDto.setBlocks(sortedArticleBlocks);
			}
		} catch (Exception e) {
			// Result could not be sorted
		}

		return articleDto;
	}

	public Article map(ArticleDto articleDto) {
		// Nicht Teil dieser Challenge.
		return new Article();
	}
}
