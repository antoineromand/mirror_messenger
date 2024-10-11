package com.deximos.mirror_messenger.application.usecase;

import org.springframework.stereotype.Service;

import com.deximos.mirror_messenger.domain.Room;
import com.deximos.mirror_messenger.domain.repository.IRoomRepository;

@Service
public class JoinRoom {
    private final IRoomRepository roomRepository;

    public JoinRoom(IRoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public String execute(String userId, int roomId) {
        System.out.printf("User %s want to join room n°%d%n", userId, roomId);
        Room room = this.roomRepository.getById(roomId);
        if (room == null) {
            System.out.printf("Room n°%d cannot be found%n", roomId);
            return null;
        }
        if (room.getUsers().contains(userId)) {
            System.out.printf("User %s has already joined the room n°%d%n", userId, roomId);
            return null;
        }
        room.getUsers().add(userId);
        return "User has joined the room";
    }
}
