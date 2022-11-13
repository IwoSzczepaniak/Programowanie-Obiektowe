package agh.ics.oop;

public class RectangularMap implements IWorldMap{
    @Override
    public boolean canMoveTo(Vector2d position){
        if (position.x < width && position.x >= 0 && position.y < height && position.y >= 0) {
            return !isOccupied(position);
        }
        return false;
    }
    @Override
    public boolean place(Animal animal){
        Vector2d animal_location = animal.getPosition();
        if (isOccupied(animal_location)) return false;
        else map[animal_location.y][animal_location.x] = animal;
        return true;
    }
    @Override
    public boolean isOccupied(Vector2d position){
        return map[position.y][position.x] != null; // albo != null
    }
    @Override
    public Object objectAt(Vector2d position){
        return map[position.y][position.x];
    }

    public void updateMap(Vector2d old_position, Vector2d new_position){
        map[new_position.y][new_position.x] = map[old_position.y][old_position.x];
        map[old_position.y][old_position.x] = null;
    }


    Object [][] map;
    int width ;
    int height;
    public RectangularMap(int width , int height){
        this.width = width;
        this.height = height;
        map = new Object[height][width];
    }
    public String toString(){
        MapVisualizer scene = new MapVisualizer(this);
        return scene.draw(new Vector2d(0,0), new Vector2d(width - 1, height - 1));
    }
}
