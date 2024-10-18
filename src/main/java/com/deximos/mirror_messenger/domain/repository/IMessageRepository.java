package com.deximos.mirror_messenger.domain.repository;

import java.util.List;

import com.deximos.mirror_messenger.domain.Message;

public interface IMessageRepository {
    public List<Message> list(int id, int start, int limit);

    public void add(String userId, String content, int roomId);

    public int getLastId();



}
