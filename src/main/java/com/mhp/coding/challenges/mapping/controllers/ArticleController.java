package com.mhp.coding.challenges.mapping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhp.coding.challenges.mapping.error.ArticleNotFoundException;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.services.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {

	private final ArticleService articleService;

	@Autowired
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@GetMapping()
	public List<ArticleDto> list() {
		return articleService.list();
	}

	@GetMapping("/{id}")
	public ArticleDto details(@PathVariable Long id) {
		ArticleDto articleDto = articleService.articleForId(id);
		if (StringUtils.isEmpty(articleDto)
				|| StringUtils.isEmpty(articleDto.getId())) {
			throw new ArticleNotFoundException();
		}
		return articleDto;
	}

	@PostMapping()
	public ArticleDto create(@RequestBody ArticleDto articleDto) {
		return articleService.create(articleDto);
	}
}
