package agh.ics.oop;
import agh.ics.oop.gui.App;
import javafx.application.Application;

import static agh.ics.oop.Direction.dir;

public class World {
    public static void main(String [] args) {
        try {
            Application.launch(App.class, args);
        }catch(IllegalArgumentException ex){
            System.out.println(ex);
        }
    }

}

