package com.deximos.mirror_messenger.domain.repository;

import com.deximos.mirror_messenger.domain.Room;
import java.util.ArrayList;

public interface IRoomRepository extends IGenericRepository<Room> {

    public void join(int roomId, String userId);

    public void quit(int roomId, String userId);

    public void create(ArrayList<String> users, String name);

    public void update(String name, int id);

}
