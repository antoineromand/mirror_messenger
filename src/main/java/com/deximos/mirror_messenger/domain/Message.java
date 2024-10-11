package com.deximos.mirror_messenger.domain;

import java.sql.Timestamp;
import java.time.Instant;

public class Message {
    private int id;
    private Timestamp timestamp;
    private String userId;
    private String content;
    private int roomId;

    public Message(int id, String content, int roomId, String userId) {
        this.id = id;
        this.timestamp = Timestamp.from(Instant.now());
        this.content = content;
        this.roomId = roomId;
        this.userId = userId;
    }

    public void notifyMessage() {
        System.out.printf("Message from %s in room n°%d : %s%n", this.userId, this.roomId, this.content);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getUserId() {
        return userId;
    }

    public void setAuthor(String userId) {
        this.userId = userId;
    }
}
