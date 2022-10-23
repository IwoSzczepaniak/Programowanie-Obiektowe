package agh.ics.oop;
import java.util.ArrayList;

public class OptionsParser {
    public MoveDirection [] parse(String [] tab) {
        ArrayList<MoveDirection> result = new ArrayList<MoveDirection>();
        int i;
        for (i = 0; i < tab.length; i++) {
            if (tab[i].equals("forward")) result.add(MoveDirection.FORWARD);
            if (tab[i].equals("f")) result.add(MoveDirection.FORWARD);
            if (tab[i].equals("backward")) result.add(MoveDirection.BACKWARD);
            if (tab[i].equals("b")) result.add(MoveDirection.BACKWARD);
            if (tab[i].equals("right")) result.add(MoveDirection.RIGHT);
            if (tab[i].equals("r")) result.add(MoveDirection.RIGHT);
            if (tab[i].equals("left")) result.add(MoveDirection.LEFT);
            if (tab[i].equals("l")) result.add(MoveDirection.LEFT);
        }
        MoveDirection [] map_result = new MoveDirection [result.size()] ;
        int j;
        for (j = 0; j < result.size(); j++)  map_result[j] = result.get(j);
        return map_result;
    }
}
