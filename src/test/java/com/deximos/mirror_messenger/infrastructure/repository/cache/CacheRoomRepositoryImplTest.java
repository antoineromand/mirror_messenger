package com.deximos.mirror_messenger.infrastructure.repository.cache;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.deximos.mirror_messenger.domain.Room;

public class CacheRoomRepositoryImplTest {

    private CacheRoomRepositoryImpl cacheRoomRepositoryImpl;

    @BeforeEach
    public void init() {
        this.cacheRoomRepositoryImpl = new CacheRoomRepositoryImpl();
    }

    @Test
    public void testRoomCreation() {
        ArrayList<String> users = new ArrayList<>();
        users.add("xxx-xx1");
        this.cacheRoomRepositoryImpl.create(users, "default");

        List<Room> rooms = this.cacheRoomRepositoryImpl.list(0, 3);
        assertEquals(1, rooms.size(), "The repository should contain exactly one room.");

        Room findedRoom = this.cacheRoomRepositoryImpl.getById(0);
        assertNotNull(findedRoom, "Room should be found after creation.");
    }

    @Test
    public void testRoomDelete() {
        ArrayList<String> users = new ArrayList<>();
        users.add("xxx-xx1");

        this.cacheRoomRepositoryImpl.create(users, "default");
        this.cacheRoomRepositoryImpl.delete(0);

        assertNull(this.cacheRoomRepositoryImpl.getById(0), "Room should be null after deletion.");
    }

    @Test
    public void testRoomUpdate() {
        ArrayList<String> users = new ArrayList<>();
        users.add("xxx-xx1");
        this.cacheRoomRepositoryImpl.create(users, "default");

        this.cacheRoomRepositoryImpl.update("test", 0);

        Room findedRoom = this.cacheRoomRepositoryImpl.getById(0);
        assertNotNull(findedRoom, "Room should exist after update.");
        assertEquals("test", findedRoom.getName(), "The room name should be updated to 'test'.");
    }

    @Test
    public void testOnNullable() {
        Room room = this.cacheRoomRepositoryImpl.getById(10);
        assertNull(room, "Nonexistent room ID should return null.");
    }

    @Test
    public void testRoomListPagination() {
        for (int i = 0; i < 5; i++) {
            ArrayList<String> users = new ArrayList<>();
            users.add("user" + i);
            this.cacheRoomRepositoryImpl.create(users, "Room" + i);
        }

        List<Room> rooms = this.cacheRoomRepositoryImpl.list(0, 3);
        assertEquals(3, rooms.size(), "List should contain exactly 3 rooms for the given limit.");

        List<Room> overflowRooms = this.cacheRoomRepositoryImpl.list(3, 10);
        assertEquals(2, overflowRooms.size(),
                "List should contain remaining rooms when limit exceeds available items.");

        List<Room> emptyRooms = this.cacheRoomRepositoryImpl.list(10, 3);
        assertTrue(emptyRooms.isEmpty(), "List should be empty when start index is beyond list size.");
    }

}
