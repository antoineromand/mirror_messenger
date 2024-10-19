package com.deximos.mirror_messenger.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.deximos.mirror_messenger.domain.Room;
import com.deximos.mirror_messenger.domain.repository.IRoomRepository;

import java.util.ArrayList;

public class JoinRoomTest {

    private JoinRoomUseCase joinRoomUseCase;
    private IRoomRepository roomRepository;

    @BeforeEach
    public void init() {
        this.roomRepository = Mockito.mock(IRoomRepository.class);
        this.joinRoomUseCase = new JoinRoomUseCase(roomRepository);
    }

    @Test
    public void testJoinRoom_Success() {
        ArrayList<String> users = new ArrayList<>();
        users.add("xxx-xxx-xx1");

        Room room = new Room(1, users, "Test Room");

        when(roomRepository.getById(1)).thenReturn(room);

        String result = joinRoomUseCase.execute("xxx-xxx-xx2", 1);

        assertEquals("User has joined the room", result);

        verify(roomRepository, times(1)).join(1, "xxx-xxx-xx2");
    }

    @Test
    public void testJoinRoom_RoomNotFound() {
        when(roomRepository.getById(1)).thenReturn(null);

        String result = joinRoomUseCase.execute("xxx-xxx-xx2", 1);

        assertNull(result);

        verify(roomRepository, never()).join(anyInt(), anyString());
    }

    @Test
    public void testJoinRoom_UserAlreadyInRoom() {
        ArrayList<String> users = new ArrayList<>();
        users.add("xxx-xxx-xx1");
        Room room = new Room(1, users, "Test Room");

        when(roomRepository.getById(1)).thenReturn(room);

        String result = joinRoomUseCase.execute("xxx-xxx-xx1", 1);

        assertNull(result);

        verify(roomRepository, never()).join(anyInt(), anyString());
    }
}
