package com.admindashboard;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrdersPane extends VBox {

    public OrdersPane() {
        this.setPadding(new Insets(20));
        this.setSpacing(20);

        // Welcome Label
        Label welcomeLabel = new Label("Orders Overview");
        welcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 28));
        welcomeLabel.setTextFill(Color.web("#333"));

        // Order metrics (UI at the top)
        HBox metricsGrid = new HBox(20);
        metricsGrid.setAlignment(Pos.CENTER_LEFT);

        Label totalOrders = createMetricBox("Total Orders", "215");
        Label delivered = createMetricBox("Delivered", "180");
        Label pending = createMetricBox("Pending", "35");

        metricsGrid.getChildren().addAll(totalOrders, delivered, pending);

        // Table
        Label recentOrdersLabel = new Label("Recent Orders");
        recentOrdersLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        recentOrdersLabel.setTextFill(Color.web("#444"));

        TableView<Order> ordersTable = new TableView<>();
        ordersTable.setPrefHeight(400);
        ordersTable.setStyle("-fx-background-radius: 12; -fx-border-radius: 12;");

        TableColumn<Order, String> idColumn = new TableColumn<>("Order ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        idColumn.setPrefWidth(120);

        TableColumn<Order, String> nameColumn = new TableColumn<>("Customer");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        nameColumn.setPrefWidth(200);

        TableColumn<Order, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        statusColumn.setPrefWidth(150);

        TableColumn<Order, String> amountColumn = new TableColumn<>("Amount");
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        amountColumn.setPrefWidth(100);

        ordersTable.getColumns().addAll(idColumn, nameColumn, statusColumn, amountColumn);
        ordersTable.setItems(getSampleOrders());

        VBox ordersSection = new VBox(10, recentOrdersLabel, ordersTable);
        ordersSection.setPadding(new Insets(10, 10, 10, 10));

        this.getChildren().addAll(welcomeLabel, metricsGrid, ordersSection);
    }

    private Label createMetricBox(String title, String value) {
        Label box = new Label(title + "\n" + value);
        box.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
        box.setTextFill(Color.WHITE);
        box.setAlignment(Pos.CENTER);
        box.setStyle("-fx-background-color: #4CAF50; -fx-padding: 20; -fx-background-radius: 10;");
        box.setMinSize(150, 70);
        box.setMaxSize(200, 100);
        return box;
    }

    private ObservableList<Order> getSampleOrders() {
        return FXCollections.observableArrayList(
                new Order("ORD101", "Avishkar C.", "Delivered", "₹450"),
                new Order("ORD102", "Rahul M.", "Pending", "₹730"),
                new Order("ORD103", "Sneha S.", "Delivered", "₹910"),
                new Order("ORD104", "Ananya P.", "Cancelled", "₹1,100"),
                new Order("ORD105", "Manish G.", "Delivered", "₹660"),
                new Order("ORD106", "Nikita D.", "Pending", "₹320"),
                new Order("ORD107", "Ravi T.", "Delivered", "₹980"),
                new Order("ORD108", "Karan B.", "Returned", "₹550"),
                new Order("ORD109", "Komal Z.", "Delivered", "₹1,450"),
                new Order("ORD110", "Zaid K.", "Pending", "₹250"),
                new Order("ORD111", "Bhavna R.", "Delivered", "₹820"),
                new Order("ORD112", "Omkar J.", "Cancelled", "₹290"),
                new Order("ORD113", "Tanvi W.", "Pending", "₹1,200"),
                new Order("ORD114", "Jatin D.", "Delivered", "₹610"),
                new Order("ORD115", "Prachi S.", "Returned", "₹700"),
                new Order("ORD116", "Ishaan V.", "Delivered", "₹1,050"),
                new Order("ORD117", "Pooja K.", "Pending", "₹300"),
                new Order("ORD118", "Yash R.", "Delivered", "₹990"),
                new Order("ORD119", "Neha A.", "Cancelled", "₹450"),
                new Order("ORD120", "Mehul B.", "Delivered", "₹780"));
    }
}
