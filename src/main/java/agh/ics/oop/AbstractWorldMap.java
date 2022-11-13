package agh.ics.oop;
import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal ani = animalsOnMap.get(oldPosition);
        animalsOnMap.remove(oldPosition);
        animalsOnMap.put(newPosition, ani);
    }
    @Override
    public boolean canMoveTo(Vector2d position){
        return !(objectAt(position) instanceof Animal);
    }
    @Override
    public boolean place(Animal animal){
        Vector2d animal_location = animal.getPosition();
        if (objectAt(animal_location) instanceof Animal) return false;
        else animalsOnMap.put(animal.getPosition(),animal);
        return true;
    }
    @Override
    public boolean isOccupied(Vector2d position){
        if (animalsOnMap.containsKey(position))  return true;
        return false;
    }
    @Override
    public Object objectAt(Vector2d position){
        if (animalsOnMap.containsKey(position)) return animalsOnMap.get(position);
        return null;
    }

    Map<Vector2d, Animal> animalsOnMap = new HashMap<>();


    public Vector2d lowLeft( Map<Vector2d, Animal> animalsOnMap) {
        int minX = 2147483647;
        int minY = 2147483647;
        for (Vector2d location : animalsOnMap.keySet()) {
            if (location.x < minX) minX = location.x;
            if (location.y < minY) minY = location.y;
        }
        return new Vector2d(minX, minY);
    }

    public Vector2d upRight( Map<Vector2d, Animal> animalsOnMap) {
        int maxX = -2147483648;
        int maxY = -2147483648;
        for (Vector2d location : animalsOnMap.keySet()) {
            if (location.x > maxX) maxX = location.x;
            if (location.y > maxY) maxY = location.y;
        }
        return new Vector2d(maxX, maxY);
    }

    public String toString(){
        MapVisualizer scene = new MapVisualizer(this);
        return scene.draw(lowLeft(animalsOnMap), upRight(animalsOnMap));
    }


}
