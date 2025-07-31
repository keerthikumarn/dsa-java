package com.lld.design.linkedin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class User {

	private String id;
	private String name;
	private String email;
	private String password;
	private Profile profile;
	private List<Connection> connections;
	private List<Message> inbox;
	private List<Message> sentMessages;
	private List<Notification> notifications;

	public User(String name, String email, String password) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.email = email;
		this.password = password;
		this.connections = new ArrayList<>();
		this.sentMessages = new ArrayList<>();
		this.inbox = new ArrayList<>();
		this.notifications = new ArrayList<>();
	}
	
	public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public void addToInbox(Message message) {
        inbox.add(message);
    }

    public void addToSentMessages(Message message) {
        sentMessages.add(message);
    }

}
