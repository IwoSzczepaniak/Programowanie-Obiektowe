package agh.ics.oop;
import static agh.ics.oop.Direction.dir;
import agh.ics.oop.Vector2d;

enum MapDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;
    public String toString(){
        return switch (this) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case EAST -> "Wschod";
            case WEST -> "Zachod";
        };
    }
    public MapDirection next(){
        return switch (this) {
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case EAST -> SOUTH;
            case WEST -> NORTH;
        };
    }
    public MapDirection previous(){
        return switch (this) {
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case EAST -> NORTH;
            case WEST -> SOUTH;
        };
    }
    public String toUnitVector(){
        return switch (this) {
            case NORTH -> "(1,0)";
            case SOUTH -> "(-1,0)";
            case EAST -> "(0,1)";
            case WEST -> "(0,-1)";
        };
    }
}

enum MoveDirection {
    FORWARD,
    BACKWARD,
    RIGHT,
    LEFT
}

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

        Vector2d position1 = new Vector2d(1,2);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        int position3 = 0;
        System.out.println(position2.equals(position3));

        MapDirection dir = MapDirection.EAST;
        System.out.println(dir.toUnitVector());
        System.out.println(dir.next());
        System.out.println(dir.previous());

    }
}

