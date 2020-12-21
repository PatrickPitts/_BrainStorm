package org.nerdcore.MazeRunner;

public class Door implements MapSite {

    private boolean isOpen = false;
    private Room room1;
    private Room room2;

    Door(){}
    Door(Room room1, Room room2){this.room1 = room1; this.room2 = room2;}

    public void enter(){}

    public Room otherSideFrom(Room room){
        if(room.equals(room1)){
            return room2;
        } else if(room.equals(room2)){
            return room1;
        } else {
            return new Room(-1);
        }
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
