package org.nerdcore.MazeRunner;

import static org.nerdcore.MazeRunner.Direction.*;

public class MazeGame {

    public static void main(String[] args) {
        Maze game = new Maze();
        Room r1 = new Room(1);
        Room r2 = new Room(2);
        Door theDoor = new Door(r1, r2);
        game.addRoom(r1); game.addRoom(r2);

        r1.setSide(NORTH, new Wall());
        r1.setSide(EAST, theDoor);
        r1.setSide(SOUTH, new Wall());
        r1.setSide(WEST, new Wall());

        r2.setSide(NORTH, new Wall());
        r2.setSide(WEST, theDoor);
        r2.setSide(SOUTH, new Wall());
        r2.setSide(EAST, new Wall());
    }
}
