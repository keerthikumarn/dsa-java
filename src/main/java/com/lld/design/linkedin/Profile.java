package com.lld.design.linkedin;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Profile {

	private String profilePictureUrl;
	private String headline;
	private String summary;
	private List<Experience> experiences;
	private List<Education> educations;
	private List<Skill> skills;

}
