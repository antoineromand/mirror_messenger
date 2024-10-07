package com.deximos.mirror_messenger.domain.repository;

public interface IRoomRepository {
    public void create(String user);

    public void join(int roomId, String userId);

    public void quit(int roomId, String userId);
}
