package agh.ics.oop.gui;
import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class App extends Application implements IPositionChangeObserver{
    private IWorldMap map;
    private GridPane gridPane;
    private SimulationEngine engine;
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Platform.runLater(() -> { drawMap(gridPane); });
    }
    @Override
    public void init(){
//        String[] args = getParameters().getRaw().toArray(new String[0]);
//        MoveDirection[] directions = new OptionsParser().parse(args);
        this.map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
//        SimulationEngine engine = new SimulationEngine(directions, this.map, positions);
        engine = new SimulationEngine(this.map, positions);
        ArrayList<Animal> anis = engine.getCreatures();
        for(Animal ani : anis ){
            ani.addObserver(this);
        }
//        Thread engineThread = new Thread(engine);
//        engineThread.start();
    }

    public void start(Stage primaryStage){
        primaryStage.setTitle("Grass Field - new visualisation");
        gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        Scene scene = new Scene(gridPane, 600, 600);
        drawMap(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void drawMap(GridPane gridPane){
        gridPane.getChildren().clear();
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


        TextField textMoves = new TextField();
        GridPane.setColumnSpan(textMoves, upR.x - lowL.x - 4);
        gridPane.add(textMoves, 3, upR.y - lowL.y +2, upR.x - lowL.x -1, 1);

        Button startButton = new Button("Write moves here:");
//        GridPane.setFillWidth(start, true);
        GridPane.setColumnSpan(startButton, 4);
        gridPane.add(startButton, 0, upR.y - lowL.y +2, 4, 1);
        startButton.setOnAction(actionEvent ->  {
            String button_string = textMoves.getText();
            Pattern ptr = Pattern.compile(" ");
            MoveDirection[] button_directions = new OptionsParser().parse(ptr.split(button_string));
//            SimulationEngine engine = new SimulationEngine(this.map);
            engine.setMoveDirection(button_directions);
            Thread engineThread = new Thread(engine);
            engineThread.start();
        });



        for (int i = 1; i <= upR.x - lowL.x +1; i++){
            for(int j = 1; j <= upR.y - lowL.y +1; j++){
                Vector2d currentPosition = new Vector2d(lowL.x+i - 1, upR.y-j + 1);
                if (this.map.isOccupied(currentPosition)){
                    try {
                        gridPane.getColumnConstraints().add(new ColumnConstraints(40));
                        gridPane.getRowConstraints().add(new RowConstraints(40));
                        gridPane.add(getImage(currentPosition), i, j, 1, 1);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }

    private VBox getImage(Vector2d currentPosition) throws FileNotFoundException{
        Object object = this.map.objectAt(currentPosition);
        if (object != null) {
            GuiElementBox elementBox = new GuiElementBox((IMapElement) object);
            return elementBox.getVbox();
        }
        return null;
    }


}
