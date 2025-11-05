package com.example.consumingevents;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.MOUSE_CLICKED;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    private CheckBox consumeEventCheckbox =
            new CheckBox("Consumir al clicar el ratón en el círculo");
    @Override
    public void start(Stage stage) {
        Circle circle = new Circle (50, 50, 50);
        circle.setFill(Color.CORAL);
        Rectangle rectangle = new Rectangle(100, 100);
        rectangle.setFill(Color.TAN);
        HBox root = new HBox();
        root.setPadding(new Insets(20));
        root.setSpacing(20);
        root.getChildren().addAll(circle, rectangle, consumeEventCheckbox);
        Scene scene = new Scene(root);
        // Registra manejadores del evento mouse-clicked a todos los nodos
        // excepto en el rectángulo y en el checkbox
        EventHandler<MouseEvent> handler = e ->
                handleEvent(e);
        EventHandler<MouseEvent> circleMeHandler = e ->
                handleEventforCircle(e);
        stage.addEventHandler(MOUSE_CLICKED, handler);
        scene.addEventHandler(MOUSE_CLICKED, handler);
        root.addEventHandler(MOUSE_CLICKED, handler);
        circle.addEventHandler(MOUSE_CLICKED, circleMeHandler);
        stage.setScene(scene);
        stage.setTitle("Consumiendo Eventos");
        stage.show();
    }
    public void handleEvent(MouseEvent e) {
        print(e);
    }
    public void handleEventforCircle(MouseEvent e) {
        print(e);
        if (consumeEventCheckbox.isSelected()) {
            e.consume();
        }
    }
    public void print(MouseEvent e) {
        String type = e.getEventType().getName();
        String source = e.getSource().getClass().getSimpleName();
        String target = e.getTarget().getClass().getSimpleName();
        // Coordenadas del ratón relativas a la fuente del evento
        double x = e.getX();
        double y = e.getY();
        System.out.println("Type=" + type + ", Target=" + target +
                ", Source=" + source +
                        ", location(" + x + ", " + y + ")");
    }
}