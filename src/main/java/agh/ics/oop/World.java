package agh.ics.oop;
import static agh.ics.oop.Direction.dir;

public class World {
    public static void run( dir[] array ) {
        for (dir curr : array) {
            String n_message = switch (curr) {
                case f -> "Do przodu";
                case b -> "Do tylu";
                case r -> "W prawo";
                case l -> "W lewo";
                default -> "";
            };
            if (!n_message.equals("")) {
                System.out.println(n_message);
            }
        }
    }

    public static dir[] change(String [] tab) {
        dir [] result = new dir[tab.length];
        for (int i = 0; i < tab.length; i++) {
            dir n_message = switch (tab[i]) {
                case "f" -> dir.f;
                case "b" -> dir.b;
                case "r" -> dir.r;
                case "l" -> dir.l;
                default -> dir.n;
            };
            result[i] = n_message;
        }
        return result;
    }


    public static void main(String [] args) {
//        MoveDirection[] directions = new OptionsParser().parse(args);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();

        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

//        MoveDirection[] directions = new OptionsParser().parse(args);
//        IWorldMap map = new NewRectangularMap(10, 5);
//        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();


    }

}

