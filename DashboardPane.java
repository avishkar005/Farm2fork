package com.admindashboard;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DashboardPane extends VBox {

    public DashboardPane() {
        this.setStyle("-fx-background-color: linear-gradient(to bottom right, #f0f4f8, #ffffff);");
        this.setPadding(new Insets(20));
        this.setSpacing(30);

        // Admin Welcome Title
        Label welcomeLabel = new Label("Welcome back, Admin 👋");
        welcomeLabel.setFont(Font.font("Segoe UI", FontWeight.EXTRA_BOLD, 30));
        welcomeLabel.setTextFill(Color.web("#1f2937"));

        Label subtext = new Label("Here's the latest overview of your platform activity");
        subtext.setFont(Font.font("Segoe UI", FontWeight.NORMAL, 16));
        subtext.setTextFill(Color.web("#4b5563"));

        VBox welcomeSection = new VBox(5, welcomeLabel, subtext);
        welcomeSection.setAlignment(Pos.TOP_LEFT);
        welcomeSection.setPadding(new Insets(10, 20, 10, 20));

        // Top Metrics Grid
        GridPane metricsGrid = new GridPane();
        metricsGrid.setPadding(new Insets(10, 20, 10, 20));
        metricsGrid.setHgap(20);
        metricsGrid.setVgap(20);

        String[][] metrics = {
                { "Total Orders", "1,294", "#12b76a" },
                { "Delivered", "968", "#10b981" },
                { "In Transit", "152", "#f59e0b" },
                { "Out for Delivery", "86", "#3b82f6" },
                { "Inventory Count", "4,328", "#8b5cf6" }
        };

        for (int i = 0; i < metrics.length; i++) {
            VBox card = createMetricCard(metrics[i][0], metrics[i][1], metrics[i][2]);
            metricsGrid.add(card, i, 0);
        }

        // Recent Orders Section
        Label recentOrdersLabel = new Label("Recent Orders");
        recentOrdersLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 22));
        recentOrdersLabel.setTextFill(Color.web("#111827"));
        recentOrdersLabel.setPadding(new Insets(0, 0, 10, 20));

        TableView<Order> ordersTable = new TableView<>();
        ordersTable.setPrefHeight(300);
        ordersTable.setStyle("-fx-background-radius: 12; -fx-border-radius: 12;");

        TableColumn<Order, String> idColumn = new TableColumn<>("Order ID");
        idColumn.setCellValueFactory(data -> data.getValue().orderIdProperty());
        idColumn.setPrefWidth(100);

        TableColumn<Order, String> nameColumn = new TableColumn<>("Customer");
        nameColumn.setCellValueFactory(data -> data.getValue().customerNameProperty());
        nameColumn.setPrefWidth(200);

        TableColumn<Order, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(data -> data.getValue().statusProperty());
        statusColumn.setPrefWidth(150);

        TableColumn<Order, String> amountColumn = new TableColumn<>("Amount");
        amountColumn.setCellValueFactory(data -> data.getValue().amountProperty());
        amountColumn.setPrefWidth(100);

        ordersTable.getColumns().addAll(idColumn, nameColumn, statusColumn, amountColumn);
        ordersTable.setItems(getSampleOrders());

        VBox ordersSection = new VBox(10, recentOrdersLabel, ordersTable);
        ordersSection.setPadding(new Insets(0, 20, 20, 20));

        this.getChildren().addAll(welcomeSection, metricsGrid, ordersSection);
    }

    private VBox createMetricCard(String title, String value, String colorHex) {
        VBox card = new VBox(10);
        card.setPadding(new Insets(20));
        card.setStyle("-fx-background-color: " + colorHex + "; -fx-background-radius: 15;");
        card.setPrefWidth(200);
        card.setAlignment(Pos.CENTER_LEFT);

        Label titleLabel = new Label(title);
        titleLabel.setFont(Font.font("Segoe UI", FontWeight.MEDIUM, 14));
        titleLabel.setTextFill(Color.WHITE);

        Label valueLabel = new Label(value);
        valueLabel.setFont(Font.font("Segoe UI", FontWeight.EXTRA_BOLD, 24));
        valueLabel.setTextFill(Color.WHITE);

        card.getChildren().addAll(titleLabel, valueLabel);
        return card;
    }

    private ObservableList<Order> getSampleOrders() {
        return FXCollections.observableArrayList(
                new Order("ORD001", "Anjali Sharma", "Delivered", "₹1,499"),
                new Order("ORD002", "Ravi Patel", "In Transit", "₹899"),
                new Order("ORD003", "Sunita Nair", "Delivered", "₹2,150"),
                new Order("ORD004", "Arjun Mehta", "Out for Delivery", "₹620"),
                new Order("ORD005", "Priya Verma", "Delivered", "₹1,050"),
                new Order("ORD006", "Kunal Joshi", "In Transit", "₹2,799"),
                new Order("ORD007", "Divya Reddy", "Delivered", "₹540"),
                new Order("ORD008", "Sameer Sheikh", "Out for Delivery", "₹1,210"),
                new Order("ORD009", "Neha Kulkarni", "Delivered", "₹3,100"),
                new Order("ORD010", "Harsh Vardhan", "Pending", "₹770"));
    }
}
