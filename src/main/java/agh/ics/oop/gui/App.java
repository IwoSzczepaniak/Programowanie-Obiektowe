package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;


public class App extends Application{
    private IWorldMap map;

    @Override
    public void init(){
        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = new OptionsParser().parse(args);
        this.map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, this.map, positions);
        engine.run();
    }

    public void start(Stage primaryStage){
        primaryStage.setTitle("Grass Field - new visualisation");
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        Scene scene = new Scene(gridPane, 600, 600);
        drawMap(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void drawMap(GridPane gridPane){
        GrassField abstractWorldMap = (GrassField) map;
        Text title = new Text("y/x");
        gridPane.add(title, 0, 0, 1, 1);
        GridPane.setHalignment(title, HPos.CENTER);
        gridPane.getColumnConstraints().add(new ColumnConstraints(30));
        gridPane.getRowConstraints().add(new RowConstraints(30));

        Vector2d lowL= abstractWorldMap.lowLeft();
        Vector2d upR = abstractWorldMap.upRight();


//      Cols
        for (int i = 1; i <= upR.x - lowL.x +1; i++){
            Label label = new Label(Integer.toString(lowL.x + i -1));
            gridPane.add(label, i, 0, 1, 1);
            gridPane.getColumnConstraints().add(new ColumnConstraints(40));
            GridPane.setHalignment(label, HPos.CENTER);
        }
//      Rows
        for (int i = 1; i <= upR.y - lowL.y +1; i++){
            Label label = new Label(Integer.toString(lowL.y + i -1));
            gridPane.add(label, 0, upR.y - lowL.y +2 - i, 1, 1);
            gridPane.getRowConstraints().add(new RowConstraints(40));
            GridPane.setHalignment(label, HPos.CENTER);
        }

        for (int i = 1; i <= upR.x - lowL.x +1; i++){
            for(int j = 1; j <= upR.y - lowL.y +1; j++){
                Label label = new Label(getThing(new Vector2d(lowL.x+i - 1, upR.y-j + 1)));
                gridPane.add(label, i, j, 1, 1);
                GridPane.setHalignment(label, HPos.CENTER);
            }
        }
    }

    private String getThing(Vector2d currentPosition) {
        String result = null;
        if (this.map.isOccupied(currentPosition)) {
            Object object = this.map.objectAt(currentPosition);
            if (object != null) {
                result = object.toString();
            } else {
                result = "";
            }
        } else {
            result = "";
        }
        return result;

    }


}
