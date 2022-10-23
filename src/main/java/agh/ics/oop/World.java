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

    public static String main(String [] args) {
        Animal ssak = new Animal();
        OptionsParser joystic = new OptionsParser();
        MoveDirection [] moves = joystic.parse(args);
        int i;
        for(i=0; i< moves.length; i++) ssak.move(moves[i]);
        return ssak.toString();
    }
}

