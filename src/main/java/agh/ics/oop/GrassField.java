package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class GrassField extends AbstractWorldMap{
    @Override
    public boolean canMoveTo(Vector2d position){
        if (!(objectAt(position) instanceof Animal)) {
            if (objectAt(position) instanceof Grass) {
                for (Grass grass : grassTuft) if (grass.isAt(position)){
                        grassTuft.remove(grass);
                        grassAdd(1);
                        return true;
                    }
            }
            return true;

        }
        return false;
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
        for(Grass grass: grassTuft) if (grass.isAt(position)) return true;
        for(Animal ani: creaturesOnMap) if (ani.isAt(position)) return true;
        return false;
    }
    @Override
    public Object objectAt(Vector2d position){
        for(Animal ani: creaturesOnMap) if (ani.isAt(position)) return ani;
        for(Grass grass: grassTuft) if (grass.isAt(position)) return grass;
        return null;
    }

    Object map;
    int n;
    private final ArrayList<Grass> grassTuft = new ArrayList<>();
    private final ArrayList<Animal> creaturesOnMap = new ArrayList<>();


    public void grassAdd(int m){
        Double doubleLimit = Math.sqrt(this.n * 10);
        int limit = doubleLimit.intValue();
        int i = 0;
        while (i < m){
            Random rand = new Random();
            int int_random = rand.nextInt(limit);
            int int_random2 = rand.nextInt(limit);
            Vector2d grassPosition = new Vector2d(int_random, int_random2);
            boolean canAddGrass = true;
            for (Grass others: grassTuft){
                if (grassPosition == others.getPosition()){
                    canAddGrass = false;
                    break;
                }
            }
            if (canAddGrass) {
                grassTuft.add(new Grass(grassPosition));
                i++;
            }
        }
    }
    public GrassField(int n){
        this.n = n;
        this.map = new Object();
        grassAdd(n);
    }

    public Vector2d lowLeft( ArrayList<Animal> creaturesOnMap, ArrayList<Grass> grassTuft) {
        int minX = creaturesOnMap.get(0).getPosition().x;
        int minY = creaturesOnMap.get(0).getPosition().y;
        for (Animal ani : creaturesOnMap) {
            if (ani.getPosition().x < minX) minX = ani.getPosition().x;
            if (ani.getPosition().y < minY) minY = ani.getPosition().y;
        }
        for (Grass grass : grassTuft) {
            if (grass.getPosition().x < minX) minX = grass.getPosition().x;
            if (grass.getPosition().y < minY) minY = grass.getPosition().y;
        }
        return new Vector2d(minX, minY);
    }

    public Vector2d upRight( ArrayList<Animal> creaturesOnMap, ArrayList<Grass> grassTuft) {
        int maxX = creaturesOnMap.get(0).getPosition().x;
        int maxY = creaturesOnMap.get(0).getPosition().y;
        for (Animal ani : creaturesOnMap) {
            if (ani.getPosition().x > maxX) maxX = ani.getPosition().x;
            if (ani.getPosition().y > maxY) maxY = ani.getPosition().y;
        }
        for (Grass grass : grassTuft) {
            if (grass.getPosition().x > maxX) maxX = grass.getPosition().x;
            if (grass.getPosition().y > maxY) maxY = grass.getPosition().y;
        }
        return new Vector2d(maxX, maxY);
    }

    public String toString () {
        MapVisualizer scene = new MapVisualizer(this);
        return scene.draw(lowLeft(creaturesOnMap, grassTuft), upRight(creaturesOnMap, grassTuft));
    }

}
