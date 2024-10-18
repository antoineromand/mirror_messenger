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
        this.cacheMessageRepository.add("xxx-xxx-001", "slt", 1);
        List<Message> messages = this.cacheMessageRepository.list(1, 0, 10);
        assertEquals(1, messages.size());
        assertEquals("xxx-xxx-001", messages.get(0).getUserId());
    }

    @Test
    public void testPagination() {
        this.cacheMessageRepository.add("xxx-xxx-001", "slt", 1);
        this.cacheMessageRepository.add("xxx-xxx-002", "slt", 1);
        List<Message> messages = this.cacheMessageRepository.list(1, 1, 10);
        assertEquals("xxx-xxx-002", messages.get(0).getUserId());
        List<Message> messages2 = this.cacheMessageRepository.list(1, 0, 1);
        assertEquals("xxx-xxx-001", messages2.get(0).getUserId());
    }
}
