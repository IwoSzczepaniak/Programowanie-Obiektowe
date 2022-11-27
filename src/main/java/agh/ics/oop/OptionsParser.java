package agh.ics.oop;
import java.util.ArrayList;

public class OptionsParser {
    public MoveDirection [] parse(String [] tab) {
        ArrayList<MoveDirection> result = new ArrayList<MoveDirection>();
        int i;
        for (i = 0; i < tab.length; i++) {
            switch (tab[i]) {
                case "forward", "f" -> result.add(MoveDirection.FORWARD);
                case "backward", "b" -> result.add(MoveDirection.BACKWARD);
                case "right", "r" -> result.add(MoveDirection.RIGHT);
                case "left", "l" -> result.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException(tab[i] + " is not legal move specification");
            }
        }
        MoveDirection [] map_result = new MoveDirection [result.size()] ;
        int j;
        for (j = 0; j < result.size(); j++) map_result[j] = result.get(j);
        return map_result;
    }
}
