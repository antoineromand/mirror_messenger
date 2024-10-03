package com.deximos.mirror_messenger.domain;

import com.deximos.mirror_messenger.domain.user.User;

public class Message { 
    private int id;
    private int timestamp;
    private User author;
    private String content;
    private Room room;
    
    public Message(int id, int timestamp, String content, Room room, User author) {
        this.id = id;
        this.timestamp = timestamp;
        this.content = content;
        this.room = room;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
    
}
