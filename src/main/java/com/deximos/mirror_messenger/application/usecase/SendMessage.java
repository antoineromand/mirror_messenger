package com.deximos.mirror_messenger.application.usecase;

import org.springframework.stereotype.Service;

import com.deximos.mirror_messenger.domain.Room;
import com.deximos.mirror_messenger.domain.repository.IMessageRepository;
import com.deximos.mirror_messenger.domain.repository.IRoomRepository;

@Service
public class SendMessage {
    private final IRoomRepository roomRepository;
    private final IMessageRepository messageRepository;

    public SendMessage(IRoomRepository roomRepository, IMessageRepository messageRepository) {
        this.roomRepository = roomRepository;
        this.messageRepository = messageRepository;
    }

    public String execute(String userId, int roomId, String content) {
        Room room = this.roomRepository.getById(roomId);
        if (room == null) {
            System.out.printf("Room n°%d cannot be found%n", roomId);
            return null;
        }
        if (!room.getUsers().contains(userId)) {
            System.out.printf("User %s not found in the room n°%d%n", userId, roomId);
            return null;
        }
        if (!content.isBlank()) {
            System.out.println("Le message ne peut pas être crée sans contenu.");
            return null;
        }
        this.messageRepository.add(userId, content, roomId);
        return "User send message";
    }
}
