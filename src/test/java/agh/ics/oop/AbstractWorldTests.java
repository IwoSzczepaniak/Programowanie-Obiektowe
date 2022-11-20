// Tests of NewRectangularMap and GrassField combined
package agh.ics.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractWorldTests {

    public void check(IWorldMap map,String dir_res, Vector2d loc_res){
        Object animal1 = map.objectAt(loc_res);
        Animal ani1 = null;
        if (animal1 instanceof Animal) {
            ani1 = (Animal) animal1;
        }
        System.out.println(ani1.getPosition());
        System.out.println(ani1.toString());
        assertEquals(loc_res, ani1.getPosition());
        assertEquals(dir_res, ani1.toString());

    }
    @Test
    public void test1() throws Exception{
        try {
            String[] tab = new String[]{"r", "f", "f", "f", "r"};
            int width = 4;
            int height = 4;
            Vector2d[] positions = {new Vector2d(2, 2)};
            MoveDirection[] directions = new OptionsParser().parse(tab);
            IWorldMap map = new NewRectangularMap(width, height);
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            check(map, "S", new Vector2d(3, 2));
        }catch(IllegalArgumentException ex){
            throw new Exception("Problem is: ", ex);
        }
    }

    @Test
    public void test2() throws Exception{
        try {
            String[] tab = new String[]{"l", "f", "l", "l", "r", "r", "f", "r", "f", "f", "f", "r", "b", "l", "l", "b"};
            int width = 12;
            int height = 10;
            Vector2d[] positions = {new Vector2d(1, 8), new Vector2d(8, 2)};
            MoveDirection[] directions = new OptionsParser().parse(tab);
            IWorldMap map = new NewRectangularMap(width, height);
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            check(map, "S", new Vector2d(1, 8));
            check(map, "E", new Vector2d(8, 3));
        }catch(IllegalArgumentException ex){
            throw new Exception("Problem is: ", ex);
        }
    }

    @Test
    public void test2exceptionDirection() {
        boolean flag = false;
        try {
            String[] tab = new String[]{"l","g", "f", "l", "l", "r", "r", "f", "r", "f", "f", "f", "r", "b", "l", "l", "b"};
            int width = 12;
            int height = 10;
            Vector2d[] positions = {new Vector2d(1, 8), new Vector2d(8, 2)};
            MoveDirection[] directions = new OptionsParser().parse(tab);
            IWorldMap map = new NewRectangularMap(width, height);
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            check(map, "S", new Vector2d(1, 8));
            check(map, "E", new Vector2d(8, 3));
        } catch (IllegalArgumentException ex) {
            flag = true;
        }finally {
            assertTrue(flag);
        }
    }


    @Test
    public void test2exceptionPosition() {
        boolean flag = false;
        try {
            String[] tab = new String[]{"l","g", "f", "l", "l", "r", "r", "f", "r", "f", "f", "f", "r", "b", "l", "l", "b"};
            int width = 12;
            int height = 10;
            Vector2d[] positions = {new Vector2d(1, 8), new Vector2d(1, 8)};
            MoveDirection[] directions = new OptionsParser().parse(tab);
            IWorldMap map = new NewRectangularMap(width, height);
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            check(map, "S", new Vector2d(1, 8));
            check(map, "E", new Vector2d(8, 3));
        } catch (IllegalArgumentException ex) {
            flag = true;
        }finally {
            assertTrue(flag);
        }
    }

    @Test
    public void test3() throws Exception{
        try{
            String [] tab = new String[]{"r", "r", "f", "r", "f", "f", "f", "f", "r", "f", "r", "f"};
            int width = 9; // 8
            int height = 10; // 9
            Vector2d [] positions = {new Vector2d(2,1), new Vector2d(7,7), new Vector2d(6,0)};
            MoveDirection[] directions = new OptionsParser().parse(tab);
            IWorldMap map = new NewRectangularMap(width, height);
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            check(map, "S", new Vector2d(2,0));
            check(map, "S", new Vector2d(8,7));
            check(map, "E", new Vector2d(7,2));
        }catch(IllegalArgumentException ex){
            throw new Exception("Problem is: ", ex);
        }
    }

    @Test
    public void test4() throws Exception{
        try {
            String[] tab = new String[]{"r", "f", "f", "f", "r"};
            int n = 5;
            Vector2d[] positions = {new Vector2d(2, 2)};
            MoveDirection[] directions = new OptionsParser().parse(tab);
            IWorldMap map = new GrassField(n);
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            check(map, "S", new Vector2d(5, 2));
        }catch(IllegalArgumentException ex){
            throw new Exception("Problem is: ", ex);
        }
    }

    @Test
    public void test5() throws Exception{
        try {
            String[] tab = new String[]{"l", "f", "l", "l", "r", "r", "f", "r", "f", "f", "f", "r", "b", "l", "l", "b"};
            int n = 10;
            Vector2d[] positions = {new Vector2d(1, 8), new Vector2d(8, 2)};
            MoveDirection[] directions = new OptionsParser().parse(tab);
            IWorldMap map = new GrassField(n);
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            check(map, "S", new Vector2d(-1, 8));
            check(map, "E", new Vector2d(8, 3));
        }catch(IllegalArgumentException ex){
            throw new Exception("Problem is: ", ex);
        }
    }


    @Test
    public void test5exceptionPDirection(){
        boolean flag = false;
        try {
            String[] tab = new String[]{"l", "f", "c", "l", "l", "r", "r", "f", "r", "f", "f", "f", "r", "b", "l", "l", "b"};
            int n = 10;
            Vector2d[] positions = {new Vector2d(1, 8), new Vector2d(8, 2)};
            MoveDirection[] directions = new OptionsParser().parse(tab);
            IWorldMap map = new GrassField(n);
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            check(map, "S", new Vector2d(-1, 8));
            check(map, "E", new Vector2d(8, 3));
        }catch(IllegalArgumentException ex){
            flag = true;
        }finally {
            assertTrue(flag);
        }
    }
    @Test
    public void test5exceptionPosition(){
        boolean flag = false;
        try {
            String[] tab = new String[]{"l", "f", "l", "l", "r", "r", "f", "r", "f", "f", "f", "r", "b", "l", "l", "b"};
            int n = 10;
            Vector2d[] positions = {new Vector2d(1, 8), new Vector2d(1, 8)};
            MoveDirection[] directions = new OptionsParser().parse(tab);
            IWorldMap map = new GrassField(n);
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            check(map, "S", new Vector2d(-1, 8));
            check(map, "E", new Vector2d(8, 3));
        }catch(IllegalArgumentException ex){
            flag = true;
        }finally {
            assertTrue(flag);
        }
    }


    @Test
    public void test6() throws Exception{
        try {
            String[] tab = new String[]{"r", "r", "f", "r", "f", "f", "f", "f", "r", "f", "r", "f"};
            int n = 20;
            Vector2d[] positions = {new Vector2d(2, 1), new Vector2d(7, 7), new Vector2d(6, 0)};
            MoveDirection[] directions = new OptionsParser().parse(tab);
            IWorldMap map = new GrassField(n);
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            check(map, "S", new Vector2d(2, -1));
            check(map, "E", new Vector2d(7, 2));
            check(map, "S", new Vector2d(9, 7));
        }catch(IllegalArgumentException ex){
            throw new Exception("Problem is: ", ex);
        }
    }

    @Test
    public void test6exceptionDirection(){
        boolean flag = false;
        try {
            String[] tab = new String[]{"r", "r", "f", "r", "f", "f", "f", "f", "r", "f", "r", "f", "Y"};
            int n = 20;
            Vector2d[] positions = {new Vector2d(2, 1), new Vector2d(7, 7), new Vector2d(6, 0)};
            MoveDirection[] directions = new OptionsParser().parse(tab);
            IWorldMap map = new GrassField(n);
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            check(map, "S", new Vector2d(2, -1));
            check(map, "E", new Vector2d(7, 2));
            check(map, "S", new Vector2d(9, 7));
        }catch(IllegalArgumentException ex){
            flag = true;
        }finally {
            assertTrue(flag);
        }
    }
    @Test
    public void test6exceptionPosition(){
        boolean flag = false;
        try {
            String[] tab = new String[]{"r", "r", "f", "r", "f", "f", "f", "f", "r", "f", "r", "f"};
            int n = 20;
            Vector2d[] positions = {new Vector2d(2, 1), new Vector2d(7, 7), new Vector2d(7, 7)};
            MoveDirection[] directions = new OptionsParser().parse(tab);
            IWorldMap map = new GrassField(n);
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            check(map, "S", new Vector2d(2, -1));
            check(map, "E", new Vector2d(7, 2));
            check(map, "S", new Vector2d(9, 7));
        }catch(IllegalArgumentException ex){
            flag = true;
        }finally {
            assertTrue(flag);
        }
    }

}
