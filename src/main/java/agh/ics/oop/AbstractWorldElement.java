package agh.ics.oop;

public class AbstractWorldElement implements IMapElement{
    Vector2d location;

    public Vector2d getPosition(){
        return location;
    }
    public String toString(){
        return "*";
    }
    public boolean isAt(Vector2d position){
        return position.equals(location);
    }
}
