package com.admindashboard;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.function.Consumer;

public class Sidebar extends VBox {

    private Consumer<String> navigationListener;

    public Sidebar() {
        setPadding(new Insets(20));
        setSpacing(15);
        setStyle("-fx-background-color: #2c3e50;");

        createNavButton("Dashboard");
        createNavButton("Transportation");
        createNavButton("Inventory");
        createNavButton("Orders");
        createNavButton("Customers");
        createNavButton("Analytics");
        createNavButton("Settings");
    }

    private void createNavButton(String name) {
        Button button = new Button(name);
        button.setPrefWidth(180);
        button.setStyle("-fx-background-color: #34495e; -fx-text-fill: white;");

        button.setOnAction(e -> {
            if (navigationListener != null) {
                navigationListener.accept(name);
            }
        });

        this.getChildren().add(button);
    }

    public void setNavigationListener(Consumer<String> listener) {
        this.navigationListener = listener;
    }
}
