package agh.ics.oop;
import java.util.Vector;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d location = new Vector2d(2, 2);

    public String toString() {
        return String.format("%s,%s", location, orientation);
    }
    public boolean isAt(Vector2d position){
        return position.equals(location);
    }
    public void move(MoveDirection direction) {
        if (direction == MoveDirection.RIGHT){
            orientation = orientation.next();
        }
        else if (direction == MoveDirection.LEFT){
            orientation = orientation.previous();
        }
        else if (direction == MoveDirection.FORWARD){
            if (orientation == MapDirection.NORTH && location.y +1 <= 4) location.y = location.y + 1;
            else if (orientation == MapDirection.EAST && location.x +1 <= 4) location.x = location.x + 1;
            else if (orientation == MapDirection.SOUTH && location.y -1 >= 0) location.y = location.y - 1;
            else if (orientation == MapDirection.WEST && location.x -1 >= 0) location.x = location.x - 1;
        }
        else if (direction == MoveDirection.BACKWARD){
            if (orientation == MapDirection.SOUTH && location.y +1 <= 4) location.y = location.y + 1;
            else if (orientation == MapDirection.WEST && location.x +1 <= 4) location.x = location.x + 1;
            else if (orientation == MapDirection.NORTH && location.y -1 >= 0) location.y = location.y - 1;
            else if (orientation == MapDirection.EAST && location.x -1 >= 0) location.x = location.x - 1;
        }

    }

}
