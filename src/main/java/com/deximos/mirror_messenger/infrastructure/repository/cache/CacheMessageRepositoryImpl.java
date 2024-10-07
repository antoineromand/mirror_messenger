package com.deximos.mirror_messenger.infrastructure.repository.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.deximos.mirror_messenger.domain.Message;
import com.deximos.mirror_messenger.domain.repository.IMessageRepository;

public class CacheMessageRepositoryImpl implements IMessageRepository {

    public List<Message> messages = new ArrayList<>();

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
    public void add(Message message) {
        this.messages.add(message);
    }
    
}
