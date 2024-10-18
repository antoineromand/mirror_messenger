package com.deximos.mirror_messenger.infrastructure.repository.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.deximos.mirror_messenger.domain.Message;
import com.deximos.mirror_messenger.domain.repository.IMessageRepository;

@Repository
public class CacheMessageRepositoryImpl implements IMessageRepository {

    public List<Message> messages = new ArrayList<>();
    private int lastId = 0;

    @Override
    public List<Message> list(int roomId, int start, int limit) {
        List<Message> filteredMessages = this.messages.stream().filter(message -> message.getRoomId() == roomId)
                .collect(Collectors.toList());
        if (start >= filteredMessages.size()) {
            return new ArrayList<>();
        }
        int end = Math.min(start + limit, filteredMessages.size());
        return filteredMessages.subList(start, end);
    }

    @Override
    public void add(String userId, String content, int roomId) {
        int lastId = this.getLastId();
        Message message = new Message(lastId, content, roomId, userId);
        this.messages.add(message);
        message.notifyMessage();
    }

    @Override
    public int getLastId() {
        int id = this.lastId;
        this.lastId++;
        return id;
    }

}
