package agh.ics.oop;

public interface IMapElement {
    Vector2d getPosition();
    String toString();
    boolean isAt(Vector2d position);

    String elementDirection();

}
