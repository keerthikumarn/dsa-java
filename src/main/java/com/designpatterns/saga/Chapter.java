package com.designpatterns.saga;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chapter {
	
	private String name;
	
	public Chapter(String name) {
		this.name = name;
	}

}
