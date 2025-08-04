package com.lld.design.linkedin;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class JobPosting {

	private String id;
	private String title;
	private String company;
	private String description;
	private String location;
	private Date postDate;
	private Map<String, User> applicants;

	public JobPosting(String title, String company, String description, String location) {
		this.id = UUID.randomUUID().toString();
		this.title = title;
		this.company = company;
		this.description = description;
		this.location = location;
		this.postDate = new Date();
		this.applicants = new ConcurrentHashMap<>();
	}

	public void apply(User user) {
		if (applicants.containsKey(user.getId())) {
			throw new IllegalArgumentException("User has already applied to the job");
		}
		applicants.put(user.getId(), user);
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getLocation() {
		return location;
	}

	public List<User> getApplicants() {
		return applicants.values().stream().toList();
	}

}
