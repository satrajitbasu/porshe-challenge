package com.mhp.coding.challenges.mapping.mappers;

import org.mapstruct.Mapper;

import com.mhp.coding.challenges.mapping.models.db.Article;
import com.mhp.coding.challenges.mapping.models.db.blocks.ArticleBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.GalleryBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.ImageBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.TextBlock;
import com.mhp.coding.challenges.mapping.models.db.blocks.VideoBlock;
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto;
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto;

@Mapper
public interface ArticleMappingProvider {

	ArticleDto articleToArticleDto(Article article);

	com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlock imageBlockToImageBlockDto(
			ImageBlock imageBlock);

	com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock textBlockToTextBlockDto(
			TextBlock textBlock);

	GalleryBlockDto galleryBlockToGalleryBlockDto(GalleryBlock galleryBlock);

	com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlock videoBlockToVideoBlockDto(
			VideoBlock videoBlock);

	default ArticleBlockDto articleBlockToArticleBlockDto(
			ArticleBlock articleBlock) {

		if (articleBlock == null) {
			return null;
		}

		ArticleBlockDto articleBlockDto = null;

		if (articleBlock instanceof com.mhp.coding.challenges.mapping.models.db.blocks.ImageBlock) {
			articleBlockDto = imageBlockToImageBlockDto((ImageBlock) articleBlock);
		} else if (articleBlock instanceof TextBlock) {
			articleBlockDto = textBlockToTextBlockDto((TextBlock) articleBlock);
		} else if (articleBlock instanceof GalleryBlock) {
			articleBlockDto = galleryBlockToGalleryBlockDto((GalleryBlock) articleBlock);
		} else if (articleBlock instanceof VideoBlock) {
			articleBlockDto = videoBlockToVideoBlockDto((VideoBlock) articleBlock);
		}

		return articleBlockDto;
	}
}
