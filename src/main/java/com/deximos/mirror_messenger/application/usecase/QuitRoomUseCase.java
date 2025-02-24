package com.deximos.mirror_messenger.application.usecase;

import org.springframework.stereotype.Service;

import com.deximos.mirror_messenger.domain.Room;
import com.deximos.mirror_messenger.domain.repository.IRoomRepository;

@Service
public class QuitRoomUseCase {
    private final IRoomRepository roomRepository;

    public QuitRoomUseCase(IRoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public String execute(String userId, int roomId) {
        System.out.printf("User %s want to left the room n°%d", userId, roomId);
        Room room = this.roomRepository.getById(roomId);
        if (room == null) {
            System.out.printf("Room n°%d cannot be found%n", roomId);
            return null;
        }
        if (!room.getUsers().contains(userId)) {
            System.out.printf("User %s not found in the room n°%d%n", userId, roomId);
            return null;
        }
        this.roomRepository.quit(roomId, userId);
        return "User left the room N°" + roomId;
    }

}
