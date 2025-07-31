package com.lld.design.linkedin;

import java.util.Date;
import java.util.UUID;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Notification {
	
	private String id;
    private User user;
    private NotificationType type;
    private String content;
    private Date timestamp;

    public Notification(User user, NotificationType type, String content) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.type = type;
        this.content = content;
        this.timestamp = new Date();
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public NotificationType getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
