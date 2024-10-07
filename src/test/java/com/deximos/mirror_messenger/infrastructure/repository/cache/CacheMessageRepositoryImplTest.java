package com.deximos.mirror_messenger.infrastructure.repository.cache;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.deximos.mirror_messenger.domain.Message;

public class CacheMessageRepositoryImplTest {

    private CacheMessageRepositoryImpl cacheMessageRepository;

    @BeforeEach
    public void init() {
        this.cacheMessageRepository = new CacheMessageRepositoryImpl();
    }

    @Test
    public void testAddMessage() {
        Message msg = new Message(1, 0, "salut", 1, "xxx-xxx-001");
        this.cacheMessageRepository.add(msg);
        List<Message> messages = this.cacheMessageRepository.list(1, 0, 10);
        assertEquals(1, messages.size());
        assertEquals(msg, messages.get(0));
    }

    @Test
    public void testPagination() {
        Message msg = new Message(1, 0, "salut", 1, "xxx-xxx-001");
        Message msg2 = new Message(2, 0, "salut", 1, "xxx-xxx-002");
        this.cacheMessageRepository.add(msg);
        this.cacheMessageRepository.add(msg2);
        List<Message> messages = this.cacheMessageRepository.list(1, 1, 10);
        assertEquals(msg2, messages.get(0));
        List<Message> messages2 = this.cacheMessageRepository.list(1, 0, 1);
        assertEquals(msg, messages2.get(0));
    }
}
