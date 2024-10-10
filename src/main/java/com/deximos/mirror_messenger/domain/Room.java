package com.deximos.mirror_messenger.domain;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;



public class Room {
    private int id;
    private Timestamp timestamp;
    private ArrayList<String> users;
    private String name;

    public Room(int id, ArrayList<String> users, String name) {
        this.id = id;
        this.timestamp = Timestamp.from(Instant.now());
        this.users = users;
        this.name = name;
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

    public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
