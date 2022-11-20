package agh.ics.oop;
import java.util.Comparator;
import java.util.Vector;

public class ComparatorX implements Comparator<Vector2d> {
    public int compare(Vector2d ani1, Vector2d ani2) {
        if (ani1.x < ani2.x) return 1;
        else if (ani1.x > ani2.x) return -1;
        else{
            if (ani1.y < ani2.y) return 1;
            else if (ani1.y > ani2.y) return -1;
        }
        return 0;
    }
}
