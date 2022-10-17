package agh.ics.oop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapDirectionTest {
    @Test
    public void testNext(){
        assertEquals(MapDirection.EAST, MapDirection.NORTH.next());
        assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
        assertEquals(MapDirection.WEST, MapDirection.SOUTH.next());
        assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
    }
    @Test
    public void testPrevious(){
        assertEquals(MapDirection.WEST, MapDirection.NORTH.previous());
        assertEquals(MapDirection.NORTH, MapDirection.EAST.previous());
        assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous());
        assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous());
    }
    @Test
    public void Vector2dTest(){

        Vector2d testowy0 = new Vector2d(1,2);
        Vector2d testowy1 = new Vector2d(1,2);
        Vector2d testowy2 = new Vector2d(3,7);
        Vector2d testowy3 = new Vector2d(5,5);
        int testowyInt = 0;

//        equals
        assertTrue(testowy0.equals(testowy1));
        assertFalse(testowy2.equals(testowy1));
        assertFalse(testowy1.equals(testowyInt));
//        toString
        assertEquals("(3,7)", testowy2.toString());
        assertEquals("(1,2)", testowy1.toString());
//        precedes
        assertTrue(testowy0.precedes(testowy2));
        assertFalse(testowy2.precedes(testowy0));
//        follows
        assertFalse(testowy0.follows(testowy2));
        assertTrue(testowy2.follows(testowy0));
//        upperRight
        Vector2d res1 = new Vector2d(5,7);
        assertEquals(res1 ,testowy2.upperRight(testowy3));
//        lowerLeft
        Vector2d res2 = new Vector2d(3,5);
        assertEquals(res2 ,testowy2.lowerLeft(testowy3));
//        add
        Vector2d res3 = new Vector2d(8,12);
        assertEquals(res3 ,testowy2.add(testowy3));
//        subtract
        Vector2d res4 = new Vector2d(-2,2);
        assertEquals(res4 ,testowy2.subtract(testowy3));
//        opposite
        Vector2d res5 = new Vector2d(7,3);
        assertEquals(res5 ,testowy2.opposite());
        assertEquals(testowy3 ,testowy3.opposite());
    }
}
