package agh.ics.oop;
import java.util.Map;
import java.util.Vector;

public class Animal {
    private MapDirection orientation;
    private Vector2d location;
    IWorldMap map;
    public Animal(){
        orientation = MapDirection.NORTH;
        location = new Vector2d(2, 2);
    }

    public Animal(IWorldMap map) {
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        orientation = MapDirection.NORTH;
        location = initialPosition;
        this.map = map;
    }
    public String toString() {
        String orient = switch (orientation) {
            case NORTH ->  "N";
            case EAST ->   "E";
            case WEST->   "W";
            case SOUTH ->  "S";
        };
        return String.format(orient);
    }
    public boolean isAt(Vector2d position){
        return position.equals(location);
    }
    public void move(MoveDirection direction) {
        Vector2d new_location = location;
        switch (direction) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD-> new_location = new_location.add(orientation.toUnitVector());
            case BACKWARD -> new_location = new_location.subtract(orientation.toUnitVector());
        }
        if (map.canMoveTo(new_location)){ //działa na mapie
            map.updateMap(location, new_location);
            location = new_location;
        }
    }

    public Vector2d loc(){
        return location;
    }

}
