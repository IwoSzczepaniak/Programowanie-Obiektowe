package agh.ics.oop;


public class Animal extends AbstractWorldElement{
    private MapDirection orientation;
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
        return orient;
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

}
