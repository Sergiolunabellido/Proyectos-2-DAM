package com.example.mouselocation;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Circle circle = new Circle (50, 50, 50);
        circle.setFill(Color.CORAL);
        Rectangle rectangle = new Rectangle(100, 100);
        rectangle.setFill(Color.TAN);
        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(circle, rectangle);
        // Añadir manejador al evento MOUSE_CLICKED en el Stage
        stage.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->
                handleMouseMove(e));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Mouse Location");
        stage.show();
    }
    public void handleMouseMove(MouseEvent e) {
        String source = e.getSource().getClass().getSimpleName();
        String target = e.getTarget().getClass().getSimpleName();
        // Localización del ratón relativa a la fuente del evento
        double sourceX = e.getX();
        double sourceY = e.getY();
        // Localización del ratón relativa a la Scene
        double sceneX = e.getSceneX();
        double sceneY = e.getSceneY();
        // Localización del ratón relativa a la pantalla
        double screenX = e.getScreenX();
        double screenY = e.getScreenY();
        System.out.println("Source=" + source +
                ", Target=" + target +
                ", Location:" +
                " source(" + sourceX + ", " + sourceY + ")" +
                ", scene(" + sceneX + ", " + sceneY + ")" +
                ", screen(" + screenX + ", " + screenY + ")");
    }
}
