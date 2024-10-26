package com.designpatterns.saga;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Service<G> implements OrchestrationChapter<G> {

	private static final Logger logger = LoggerFactory.getLogger(Service.class);

	@Override
	public abstract String getName();

	@Override
	public ChapterResult<G> process(G value) {
		logger.info("The chapter '{}' has been started. " + "The data {} has been stored or calculated successfully",
				getName(), value);
		return ChapterResult.success(value);
	}

	@Override
	public ChapterResult<G> rollback(G value) {
		logger.info(
				"The Rollback for a chapter '{}' has been started. " + "The data {} has been rollbacked successfully",
				getName(), value);
		return ChapterResult.failure(value);
	}
}
