package com.example.capturebubblingorder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;

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

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Fases de captura y burbuja - Orden de ejecución");
        stage.show();

        // Crear dos EventHandler de tipo filter y handler
        EventHandler<MouseEvent> filter = e ->
                handleEvent("Capture", e);
        EventHandler<MouseEvent> handler = e ->
                handleEvent("Bubbling", e);

        // Registrar filters
        stage.addEventFilter(MOUSE_CLICKED, filter);
        scene.addEventFilter(MOUSE_CLICKED, filter);
        root.addEventFilter(MOUSE_CLICKED, filter);
        circle.addEventFilter(MOUSE_CLICKED, filter);
        rectangle.addEventFilter(MOUSE_CLICKED, filter);

        // Registrar handlers
        stage.addEventHandler(MOUSE_CLICKED, handler);
        scene.addEventHandler(MOUSE_CLICKED, handler);
        root.addEventHandler(MOUSE_CLICKED, handler);
        circle.addEventHandler(MOUSE_CLICKED, handler);
        rectangle.addEventHandler(MOUSE_CLICKED, handler);
    }

    public void handleEvent(String phase, MouseEvent e) {
        String type = e.getEventType().getName();
        String source = e.getSource().getClass().getSimpleName();
        String target = e.getTarget().getClass().getSimpleName();
        // Coordenadas del ratón relativas a la fuente del evento
        double x = e.getX();
        double y = e.getY();
        System.out.println(phase + ": Type=" + type +
            ", Target=" + target +
            ", Source=" + source +
            ", location(" + x + ", " + y + ")"
            );
    }
}
