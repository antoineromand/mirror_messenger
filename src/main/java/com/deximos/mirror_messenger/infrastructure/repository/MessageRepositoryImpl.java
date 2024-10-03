package com.deximos.mirror_messenger.infrastructure.repository;

import java.util.List;

import com.deximos.mirror_messenger.domain.Message;
import com.deximos.mirror_messenger.domain.repository.IMessageRepository;

public class MessageRepositoryImpl implements IMessageRepository {

    @Override
    public List<Message> list(int id, int start, int limit) {
        throw new UnsupportedOperationException("Unimplemented method 'list'");
    }
    
}
