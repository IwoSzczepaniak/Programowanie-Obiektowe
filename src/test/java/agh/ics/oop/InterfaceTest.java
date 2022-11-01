package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InterfaceTest {

    public void check(IWorldMap map,String dir_res, Vector2d loc_res){
        Object animal1 = map.objectAt(loc_res);
        Animal ani1 = null;
        if (animal1 instanceof Animal) {
            ani1 = (Animal) animal1;
        }
        assertEquals(loc_res, ani1.loc());
        assertEquals(dir_res, ani1.toString());
    }
    @Test
    public void test1() {
        String [] tab = new String[]{"r","f","f","f","r"};
        int width = 4;
        int height = 4;
        Vector2d [] positions = {new Vector2d(2,2)};
        MoveDirection[] directions = new OptionsParser().parse(tab);
        IWorldMap map = new RectangularMap(width, height);
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        check(map, "S", new Vector2d(3,2));
    }



    @Test
    public void test2() {
        String [] tab = new String[]{"l","f","l","l","r", "r", "f", "r", "f", "f", "f", "r", "b", "l", "l", "b"};
        int width = 12;
        int height = 10;
        Vector2d [] positions = {new Vector2d(1,8), new Vector2d(8,2)};
        MoveDirection[] directions = new OptionsParser().parse(tab);
        IWorldMap map = new RectangularMap(width, height);
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        check(map, "S", new Vector2d(1,8));
        check(map, "E", new Vector2d(8,3));
    }


    @Test
    public void test3() {
        String [] tab = new String[]{"r", "r", "f", "r", "f", "f", "f", "f", "r", "f", "r", "f"};
        int width = 9; // 8
        int height = 10; // 9
        Vector2d [] positions = {new Vector2d(2,1), new Vector2d(7,7), new Vector2d(6,0)};
        MoveDirection[] directions = new OptionsParser().parse(tab);
        IWorldMap map = new RectangularMap(width, height);
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        check(map, "S", new Vector2d(2,0));
        check(map, "S", new Vector2d(8,7));
        check(map, "E", new Vector2d(7,2));

    }

}
