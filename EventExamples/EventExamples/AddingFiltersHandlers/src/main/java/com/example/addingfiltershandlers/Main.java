package com.example.addingfiltershandlers;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Circle;


import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        Circle circle = new Circle (100, 100, 50, Color.CORAL);

        // Crear MouseEvent filter
        EventHandler<MouseEvent> mouseEventFilter =
                e -> System.out.println("Mouse event filter ha sido llamado.");
        // Crear MouseEvent handler
        EventHandler<MouseEvent> mouseEventHandler =
                e -> System.out.println("Mouse event handler ha sido llamado.");

        // Registrar MouseEvent filter y MouseEvent handler en el círculo
        // para eventos de tipo mouse-clicked
        circle.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventFilter);
        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandler);

        // Eliminar MouseEvent filter y MouseEvent handler del círculo
        circle.setOnMouseClicked(e -> {
            System.out.println("MouseEvent Filter y MouseEvent Handler han sido eliminados.");
            circle.removeEventFilter(MouseEvent.MOUSE_CLICKED, mouseEventFilter);
            circle.removeEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandler);
        });

        // Añadir el círculo al layout
        root.getChildren().add(circle);

        // Añadir el layout a la escena y esta al escenario
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Utilizando métodos add() y remove()");
        stage.setScene(scene);
        stage.show();
    }
}
