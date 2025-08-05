package com.admindashboard;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class MainDashboard extends Application {

    private BorderPane mainLayout;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("AdminDash");

        mainLayout = new BorderPane();
        mainLayout.setLeft(createSidebar());
        mainLayout.setCenter(new DashboardPane()); // default view

        Scene scene = new Scene(mainLayout, 850, 650, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createSidebar() {
        VBox sidebar = new VBox(20);
        sidebar.setPadding(new Insets(30));
        sidebar.setStyle("-fx-background-color: #0f172a;");

        Label logo = new Label("🗂 AdminDash");
        logo.setTextFill(Color.WHITE);
        logo.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        VBox menu = new VBox(15);
        String[] items = { "Dashboard", "Orders", "Products", "Customers" };
        for (String item : items) {
            Button btn = new Button(item);
            btn.setPrefWidth(150);
            btn.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
            btn.setOnAction(e -> switchView(item));
            menu.getChildren().add(btn);
        }

        Label adminLabel = new Label("ADMINISTRATION");
        adminLabel.setTextFill(Color.GRAY);
        adminLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 12));

        VBox adminMenu = new VBox(15);
        String[] adminItems = { "Settings", "User Management" };
        for (String item : adminItems) {
            Button btn = new Button(item);
            btn.setPrefWidth(150);
            btn.setStyle("-fx-background-color: transparent; -fx-text-fill: white;");
            adminMenu.getChildren().add(btn);
        }

        sidebar.getChildren().addAll(logo, menu, adminLabel, adminMenu);
        return sidebar;
    }

    private void switchView(String section) {
        switch (section) {
            case "Dashboard":
                mainLayout.setCenter(new DashboardPane());
                break;
            case "Orders":
                mainLayout.setCenter(new OrdersPane());
                break;
            case "Products":
                mainLayout.setCenter(new SettingsPane());
                break;
            case "Customers":
                mainLayout.setCenter(new CustomersPane());
                break;
            default:
                mainLayout.setCenter(new Label("Section Not Found"));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
