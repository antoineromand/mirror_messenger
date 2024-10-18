package com.deximos.mirror_messenger.infrastructure.repository.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.deximos.mirror_messenger.domain.Room;
import com.deximos.mirror_messenger.domain.repository.IRoomRepository;

@Repository
public class CacheRoomRepositoryImpl implements IRoomRepository {

    List<Room> rooms = new ArrayList<>();
    private int lastId = 0;

    public int getLastId() {
        int id = this.lastId;
        this.lastId++;
        return id;
    }

    @Override
    public Room getById(int roomId) {
        return this.rooms.stream().filter(r -> r.getId() == roomId).findFirst().orElse(null);
    }

    @Override
    public List<Room> list(int start, int limit) {
        if (start >= this.rooms.size()) {
            return new ArrayList<>();
        }
        int end = Math.min(start + limit, this.rooms.size());
        return this.rooms.subList(start, end);
    }

    @Override
    public void create(ArrayList<String> users, String name) {
        int lastId = this.getLastId();
        Room room = new Room(lastId, users, name);
        this.rooms.add(room);
        System.out.printf("A new room has been added by user %s%n", room.getUsers().get(0));
    }

    @Override
    public void update(String name, int roomId) {
        Optional<Room> optionalRoom = this.rooms.stream().filter(r -> r.getId() == roomId).findFirst();
        if (!optionalRoom.isPresent()) {
            System.out.printf("Cannot find room n°%d%n", roomId);
            return;
        }
        Room existingRoom = optionalRoom.get();
        if (!name.equals(existingRoom.getName())) {
            String existingName = existingRoom.getName();
            existingRoom.setName(name);
            System.out.printf("The name for room n°%d has been updated: %s -> %s%n", roomId, existingName,
                    name);
        }
    }

    @Override
    public void delete(int roomId) {
        boolean isRemoved = this.rooms.removeIf(room -> room.getId() == roomId);
        if (isRemoved) {
            System.out.printf("Room n°%d has been deleted.%n", roomId);
        }
        System.out.printf("No room found with id n°%d to delete.%n", roomId);
    }

    @Override
    public void join(int roomId, String userId) {
        Room room = getById(roomId);
        if (room == null) {
            System.out.printf("Cannot find room n°%d%n", roomId);
            return;
        }
        if (!room.getUsers().contains(userId)) {
            room.getUsers().add(userId);
            System.out.printf("User %s has joined room n°%d.%n", userId, roomId);
        }
    }

    @Override
    public void quit(int roomId, String userId) {
        Room room = getById(roomId);
        if (room == null) {
            System.out.printf("Cannot find room n°%d%n", roomId);
            return;
        }
        if (room.getUsers().contains(userId)) {
            room.getUsers().remove(userId);
            System.out.printf("User %s has quit room n°%d.%n", userId, roomId);
        } else {
            System.out.printf("User %s is not in room n°%d.%n", userId, roomId);
        }
    }

}
