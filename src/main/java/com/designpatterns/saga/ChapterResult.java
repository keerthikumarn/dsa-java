package com.designpatterns.saga;

import lombok.Getter;

public class ChapterResult<G> {

	@Getter
	private final G value;
	private final State state;

	ChapterResult(G value, State state) {
		this.value = value;
		this.state = state;
	}

	public boolean isSuccess() {
		return state == State.SUCCESS;
	}

	public static <G> ChapterResult<G> success(G value) {
		return new ChapterResult<>(value, State.SUCCESS);
	}

	public static <G> ChapterResult<G> failure(G value) {
		return new ChapterResult<>(value, State.FAILURE);
	}
}
