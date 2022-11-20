package agh.ics.oop;
import java.util.*;

public class MapBoundary implements IPositionChangeObserver{

    SortedSet<Vector2d> yGreki;
    SortedSet<Vector2d> xKsy;

    public MapBoundary(){
        this.yGreki = new TreeSet<>(new ComparatorY());
        this.xKsy = new TreeSet<>(new ComparatorX());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        removeElement(oldPosition);
        addElement(newPosition);
    }

    public void addElement(Vector2d newElement){
        yGreki.add(newElement);
        xKsy.add(newElement);
    }

    public void removeElement(Vector2d newElement){
        yGreki.remove(newElement);
        xKsy.remove(newElement);
    }

    public Vector2d lowerLeft(){
        return new Vector2d(xKsy.last().x, yGreki.last().y);
    }
    public Vector2d upperRight(){
        return new Vector2d(xKsy.first().x, yGreki.first().y);
    }
}
