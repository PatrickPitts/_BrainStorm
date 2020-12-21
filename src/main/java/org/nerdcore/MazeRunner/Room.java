package org.nerdcore.MazeRunner;

import java.util.HashMap;
import java.util.Map;

public class Room implements MapSite {

    private int roomNumber;
    private Map<Direction, MapSite> neighbors = new HashMap<>();

    Room(int roomNumber){this.roomNumber = roomNumber;}

    public void enter(){
        System.out.println(this);
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setSide(Direction dir, MapSite site){
        this.neighbors.put(dir, site);
    }

    public MapSite getSide(Direction dir){
        return this.neighbors.get(dir);
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Room)) return false;
        return this.roomNumber == ((Room) obj).roomNumber;
    }

    @Override
    public String toString(){
        return String.format("This is Room No. %d.",this.roomNumber);
    }
}
