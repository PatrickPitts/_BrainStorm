package org.nerdcore.MazeRunner;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class Maze {

    private List<Room> rooms;

    Maze() {
        this.rooms = new ArrayList<>();
    }

    void addRoom(Room newRoom) {
        this.rooms.add(newRoom);
    }

    Room roomNo(int roomNum) {
        for (Room room : this.rooms) {
            if (room.getRoomNumber() == roomNum) {
                return room;
            }
        }
        return new Room(-1);
    }
}
