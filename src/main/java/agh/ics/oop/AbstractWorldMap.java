package agh.ics.oop;

import java.util.ArrayList;

abstract class AbstractWorldMap implements IWorldMap{
    @Override
    public boolean canMoveTo(Vector2d position){
        return !(objectAt(position) instanceof Animal);
    }
    @Override
    public boolean place(Animal animal){
        Vector2d animal_location = animal.getPosition();
        if (objectAt(animal_location) instanceof Animal) return false;
        else creaturesOnMap.add(animal);
        return true;
    }
    @Override
    public boolean isOccupied(Vector2d position){
        for(Animal ani: creaturesOnMap) if (ani.isAt(position)) return true;
        return false;
    }
    @Override
    public Object objectAt(Vector2d position){
        for(Animal ani: creaturesOnMap) if (ani.isAt(position)) return ani;
        return null;
    }
    @Override
    public void updateMap(Vector2d old_position, Vector2d new_position){
        new_position = old_position;
        old_position = null; // whatever?
    }

    private final ArrayList<Animal> creaturesOnMap = new ArrayList<>();



    public Vector2d lowLeft( ArrayList<Animal> creaturesOnMap) {
        int minX = creaturesOnMap.get(0).getPosition().x;
        int minY = creaturesOnMap.get(0).getPosition().y;
        for (Animal ani : creaturesOnMap) {
            if (ani.getPosition().x < minX) minX = ani.getPosition().x;
            if (ani.getPosition().y < minY) minY = ani.getPosition().y;
        }
        return new Vector2d(minX, minY);
    }

    public Vector2d upRight( ArrayList<Animal> creaturesOnMap) {
        int maxX = creaturesOnMap.get(0).getPosition().x;
        int maxY = creaturesOnMap.get(0).getPosition().y;
        for (Animal ani : creaturesOnMap) {
            if (ani.getPosition().x > maxX) maxX = ani.getPosition().x;
            if (ani.getPosition().y > maxY) maxY = ani.getPosition().y;
        }
        return new Vector2d(maxX, maxY);
    }

    public String toString(){
        MapVisualizer scene = new MapVisualizer(this);
        return scene.draw(lowLeft(creaturesOnMap), upRight(creaturesOnMap));
    }


}
