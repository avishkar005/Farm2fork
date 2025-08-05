package com.admindashboard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Sidebar on the left
        Sidebar sidebar = new Sidebar();
        root.setLeft(sidebar);

        // Initial View
        DashboardPane dashboardView = new DashboardPane();
        root.setCenter(dashboardView);

        // Navigation Listener for sidebar buttons
        sidebar.setNavigationListener(viewName -> {
            switch (viewName) {
                case "Dashboard":
                    root.setCenter(new DashboardPane());
                    break;
                case "Transportation":
                    root.setCenter(new TransportationPane());
                    break;
                case "Inventory":
                    root.setCenter(new InventoryPane());
                    break;
                case "Orders":
                    root.setCenter(new OrdersPane());
                    break;
                case "Customers":
                    root.setCenter(new CustomersPane());
                    break;
                case "Analytics":
                    root.setCenter(new AnalyticsPane());
                    break;
                case "Settings":
                    root.setCenter(new SettingsPane());
                    break;
                default:
                    root.setCenter(new DashboardPane()); // fallback
                    break;
            }
        });

        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setTitle("Farm2Fork Admin Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
