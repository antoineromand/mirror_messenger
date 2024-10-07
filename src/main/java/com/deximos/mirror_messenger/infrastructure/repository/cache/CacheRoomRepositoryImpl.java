package com.deximos.mirror_messenger.infrastructure.repository.cache;

import java.util.ArrayList;
import java.util.List;

import com.deximos.mirror_messenger.domain.Room;
import com.deximos.mirror_messenger.domain.repository.IRoomRepository;

public class CacheRoomRepositoryImpl implements IRoomRepository {

    List<Room> rooms = new ArrayList<>();
    int lastId = 0;

    @Override
    public void create(String userId) {
        ArrayList<String> users = new ArrayList<>();
        users.add(userId);
        Room room = new Room(lastId++, null, users, "default");
        this.rooms.add(room);
        System.out.printf("A new room (id %d) has been created by User %s%n", room.getId(), userId);
    }

    @Override
    public void join(int roomId, String userId) {
        Room room = this.rooms.stream().filter(r -> r.getId() == roomId).findFirst().orElse(null);
        if (room != null) {
            if (!room.getUsers().contains(userId)) {
                room.getUsers().add(userId);
                System.out.printf("User %s has joined room %d%n", userId, room.getId());
            } else {
                System.out.printf("Error: User %s has already joined room %d%n", userId, room.getId());
            }
        } else {
            System.out.printf("Error: Cannot find room %d", roomId);
        }
    }

    @Override
    public void quit(int roomId, String userId) {
        Room room = this.rooms.stream().filter(r -> r.getId() == roomId).findFirst().orElse(null);
        if (room != null) {
            if (room.getUsers().contains(userId)) {
                room.getUsers().remove(userId);
                System.out.printf("User %s has quit room %d%n", userId, room.getId());
            } else {
                System.out.printf("Error: Cannot find User %s in room %d%n", userId, room.getId());
            }
        } else {
            System.out.printf("Error: Cannot find room %d", roomId);
        }
    }

}
