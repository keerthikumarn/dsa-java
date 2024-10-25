package com.designpatterns.saga;

public interface OrchestrationChapter<G> {
	
	String getName();

	ChapterResult<G> process(G value);

	ChapterResult<G> rollback(G value);

}
