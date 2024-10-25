package com.designpatterns.saga;

import java.util.ArrayList;
import java.util.List;

public class Saga {

	private List<Chapter> chapters = null;

	private Saga() {
		this.chapters = new ArrayList<>();
	}

	public Saga chapter(String name) {
		this.chapters.add(new Chapter(name));
		return this;
	}
	
	public boolean isPresent(int index) {
		return index >= 0 && index < chapters.size();
	}
	
	public static Saga createSaga() {
		return new Saga();
	}
	
	

}
