package agh.ics.oop;


import java.util.ArrayList;

public class Animal extends AbstractWorldElement{
    private ArrayList<IPositionChangeObserver> observerList;
    private MapDirection orientation;
    AbstractWorldMap worldMap;

    public Animal(){
        orientation = MapDirection.NORTH;
        location = new Vector2d(2, 2);
    }
    public Animal(IWorldMap map) {
        this.worldMap = (AbstractWorldMap)map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition){
        orientation = MapDirection.NORTH;
        location = initialPosition;
        this.worldMap = (AbstractWorldMap) map;
        this.observerList = new ArrayList<>();
        addObserver(worldMap);
    }
    @Override
    public String elementDirection(){
        return switch (orientation) {
            case NORTH -> "src/main/resources/up.png";
            case SOUTH -> "src/main/resources/down.png";
            case EAST -> "src/main/resources/right.png";
            case WEST -> "src/main/resources/left.png";
        };
    }

    public void addObserver(IPositionChangeObserver observer){
        observerList.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        observerList.remove(observer);
    }
    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer: observerList){
            observer.positionChanged(oldPosition, newPosition);
        }
    }

    public String toString() {
        return switch (orientation) {
            case NORTH ->  "N";
            case EAST ->   "E";
            case WEST->   "W";
            case SOUTH ->  "S";
        };
    }
    public void move(MoveDirection direction) {
        Vector2d new_location = location;
        switch (direction) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD-> new_location = new_location.add(orientation.toUnitVector());
            case BACKWARD -> new_location = new_location.subtract(orientation.toUnitVector());
        }
        if (worldMap.canMoveTo(new_location)){
            positionChanged(location, new_location);
            location = new_location;
        }
        else positionChanged(location, location);
    }

}
