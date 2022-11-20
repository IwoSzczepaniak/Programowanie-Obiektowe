// New version of Rectangular Map extending AbstractWorldMap

package agh.ics.oop;

public class NewRectangularMap extends AbstractWorldMap{
    int width ;
    int height;
    public NewRectangularMap(int width , int height){
        this.width = width;
        this.height = height;}

    @Override
    public boolean canMoveTo(Vector2d position){
        if (position.x < width && position.x >= 0 && position.y < height && position.y >= 0) {
            return !(objectAt(position) instanceof Animal);
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position){
        if (animalsOnMap.containsKey(position)) return animalsOnMap.get(position);
        return null;
    }

    @Override
    public boolean isOccupied(Vector2d position){
        if (animalsOnMap.containsKey(position))  return true;
        return false;
    }
    public Vector2d lowLeft(){
        int minX = 2147483647;
        int minY = 2147483647;
        for (Vector2d location : animalsOnMap.keySet()) {
            if (location.x < minX) minX = location.x;
            if (location.y < minY) minY = location.y;
        }
        return new Vector2d(minX, minY);
    }

    public Vector2d upRight(){
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
        return scene.draw(lowLeft(), upRight());
    }
}
