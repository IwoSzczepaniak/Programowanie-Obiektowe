package agh.ics.oop;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.lang.Math;

public class GrassField extends AbstractWorldMap{
    @Override
    public boolean canMoveTo(Vector2d position){
        if (!(objectAt(position) instanceof Animal)) {
            if (objectAt(position) instanceof Grass) {
                if (grassOnMap.containsKey(position)){
                        grassOnMap.remove(position);
                        grassAdd(1);
                        return true;
                    }
            }
            return true;

        }
        return false;
    }
    @Override
    public boolean isOccupied(Vector2d position){
        if(animalsOnMap.containsKey(position))  return true;
        if(grassOnMap.containsKey(position))  return true;
        return false;
    }
    @Override
    public Object objectAt(Vector2d position){
        if (animalsOnMap.containsKey(position)) return animalsOnMap.get(position);
        if (grassOnMap.containsKey(position)) return grassOnMap.get(position);
        return null;
    }
    int n;
    Map<Vector2d, Grass> grassOnMap = new HashMap<>();

    public void grassAdd(int m){
        Double doubleLimit = Math.sqrt(this.n * 10);
        int limit = doubleLimit.intValue();
        int i = 0;
        while (i < m){
            Random rand = new Random();
            int int_random = rand.nextInt(limit);
            int int_random2 = rand.nextInt(limit);
            Vector2d grassPosition = new Vector2d(int_random, int_random2);
            boolean canAddGrass = !grassOnMap.containsKey(grassPosition);
            if (canAddGrass) {
                Grass newGrass = new Grass(grassPosition);
                grassOnMap.put(newGrass.getPosition(), newGrass);
                i++;
            }
        }
    }
    public GrassField(int n){
        this.n = n;
        grassAdd(n);
    }

    public Vector2d lowLeft( Map<Vector2d, Animal> animalsOnMap, Map<Vector2d, Grass> grassOnMap) {
        int minX = 2147483647;
        int minY = 2147483647;
        for (Vector2d location : animalsOnMap.keySet()) {
            if (location.x < minX) minX = location.x;
            if (location.y < minY) minY = location.y;
        }
        for (Vector2d location : grassOnMap.keySet()) {
            if (location.x < minX) minX = location.x;
            if (location.y < minY) minY = location.y;
        }
        return new Vector2d(minX, minY);
    }

    public Vector2d upRight( Map<Vector2d, Animal> animalsOnMap, Map<Vector2d, Grass> grassOnMap) {
        int maxX = -2147483648;
        int maxY = -2147483648;
        for (Vector2d location : animalsOnMap.keySet()) {
            if (location.x > maxX) maxX = location.x;
            if (location.y > maxY) maxY = location.y;
        }
        for (Vector2d location : grassOnMap.keySet()) {
            if (location.x > maxX) maxX = location.x;
            if (location.y > maxY) maxY = location.y;
        }
        return new Vector2d(maxX, maxY);
    }

    public String toString () {
        MapVisualizer scene = new MapVisualizer(this);
        return scene.draw(lowLeft(animalsOnMap, grassOnMap), upRight(animalsOnMap, grassOnMap));
    }

}
