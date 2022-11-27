package agh.ics.oop.gui;

import agh.ics.oop.Animal;
import agh.ics.oop.IMapElement;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class GuiElementBox {

    Image image;
    ImageView imageView;
    IMapElement element;

    public GuiElementBox(IMapElement element) throws FileNotFoundException {
        image = new Image(new FileInputStream(element.elementDirection()));
        imageView = new ImageView(image);
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        this.element = element;
    }

    public VBox getVbox(){
        VBox vbox;
        Label label;
        if (element instanceof Animal) {
            label = new Label("A"+element.getPosition().toString());
        }
        else {
            label = new Label("Grass");
        }
        vbox = new VBox(imageView, label);
        vbox.setAlignment(Pos.CENTER);
        GridPane.setHalignment(vbox, HPos.CENTER);
        return vbox;
    }
}
