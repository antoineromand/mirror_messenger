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
        return this.messages.stream().filter(message -> message.getRoomId() == roomId).collect(Collectors.toList());
    }
    
    public void add(Message message) {
        this.messages.add(message);
    }
    
}
