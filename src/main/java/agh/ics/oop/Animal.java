package agh.ics.oop;


import java.util.ArrayList;

public class Animal extends AbstractWorldElement{
    private ArrayList<IPositionChangeObserver> observerList;
    private MapDirection orientation;
    IWorldMap map;
    AbstractWorldMap worldMap;

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
        this.worldMap = (AbstractWorldMap) map;
        this.observerList = new ArrayList<>();
        addObserver(worldMap);
    }
    void addObserver(IPositionChangeObserver observer){
        observerList.add(observer);
    }
    void removeObserver(IPositionChangeObserver observer){
        observerList.remove(observer);
    }
    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer: observerList){
            observer.positionChanged(oldPosition, newPosition);
        }
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
        if (worldMap.canMoveTo(new_location)){ //działa na mapie
            positionChanged(location, new_location);
//            worldMap.updateMap(location, new_location);
            location = new_location;

        }
    }

}
