// New version of Rectangular Map extending AbstractWorldMap

package agh.ics.oop;

public class NewRectangularMap extends AbstractWorldMap{
    @Override
    public boolean canMoveTo(Vector2d position){
        if (position.x < width && position.x >= 0 && position.y < height && position.y >= 0) {
            return !(objectAt(position) instanceof Animal);
        }
        return false;
    }
    int width ;
    int height;

    public NewRectangularMap(int width , int height){
        this.width = width;
        this.height = height;}
}
