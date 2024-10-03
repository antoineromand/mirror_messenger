package com.deximos.mirror_messenger.domain;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.deximos.mirror_messenger.domain.user.UserWithRole;


public class Room {
    private int id;
    private Timestamp timestamp;
    private ArrayList<UserWithRole> users;
    private String name;

    public Room(int id, Timestamp timestamp, ArrayList<UserWithRole> users, String name) {
        this.id = id;
        this.timestamp = timestamp;
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

    public ArrayList<UserWithRole> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserWithRole> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
