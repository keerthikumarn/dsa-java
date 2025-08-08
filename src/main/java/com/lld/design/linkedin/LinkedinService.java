package com.lld.design.linkedin;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LinkedinService {

	private static LinkedinService instance;
	private final Map<String, User> users;
	private final Map<String, JobPosting> jobPostings;
	private final Map<String, List<Notification>> notifications;

	private LinkedinService() {
		users = new ConcurrentHashMap<>();
		jobPostings = new ConcurrentHashMap<>();
		notifications = new ConcurrentHashMap<>();
	}

	public static LinkedinService getInstance() {
		if (instance == null) {
			instance = new LinkedinService();
		}
		return instance;
	}

	public User register(String name, String email, String password) {
		User newUser = new User(name, email, password);
		users.put(newUser.getId(), newUser);
		return newUser;
	}

	public User loginUser(String email, String password) {
		for (User user : users.values()) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	
	public List<User> searchUsers(String keyword) {
        List<User> results = new ArrayList<>();
        for (User user : users.values()) {
            if (user.getName().contains(keyword)) {
                results.add(user);
            }
        }
        return results;
    }

	public void sendConnectionRequest(User sender, User receiver) {
		if (sender == null || receiver == null) {
			throw new IllegalArgumentException("Sender or receiver cannot be null");
		}
		Connection connection = new Connection(sender, new Timestamp(System.currentTimeMillis()));
		receiver.getConnections().add(connection);
		sendNotification(receiver, NotificationType.CONNECTION_REQUEST,
				"New connection request from " + sender.getName());
	}

	public void acceptConnectionRequest(User user, User connectionUser) {
		for (Connection connection : user.getConnections()) {
			if (connection.getUser().equals(connectionUser)) {
				user.getConnections().add(new Connection(connectionUser, new Timestamp(System.currentTimeMillis())));
				break;
			}
		}
	}

	public JobPosting postJobListing(String title, String company, String description, String location) {
		JobPosting jobPosting = new JobPosting(title, company, description, location);
		jobPostings.put(jobPosting.getId(), jobPosting);
		return jobPosting;
	}

	public List<JobPosting> searchJobPostings(String keyword) {
		List<JobPosting> results = new ArrayList<>();
		for (JobPosting jobPosting : jobPostings.values()) {
			if (jobPosting.getTitle().contains(keyword) || jobPosting.getDescription().contains(keyword)) {
				results.add(jobPosting);
			}
		}
		return results;
	}

	public void sendMessage(User sender, User receiver, String content) {
		Message message = new Message(sender, receiver, content);
		receiver.addToInbox(message);
		sender.addToSentMessages(message);
		sendNotification(receiver, NotificationType.MESSAGE, "New message from " + sender.getName());
	}

	private void sendNotification(User receiver, NotificationType type, String message) {
		Notification notification = new Notification(receiver, type, message);
		receiver.addNotification(notification);
	}

	public List<Notification> getNotifications(String userId) {
		return users.get(userId).getNotifications();
	}
}
