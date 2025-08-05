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

public class CustomersPane extends VBox {
    public CustomersPane() {
        this.setSpacing(20);
        this.setPadding(new Insets(20));
        this.setStyle("-fx-background-color: white;");

        Label title = new Label("\uD83D\uDC65 Customer Management");
        title.setFont(Font.font("Segoe UI", FontWeight.EXTRA_BOLD, 24));

        Label subtitle = new Label("Track and manage your customers effectively");
        subtitle.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 16));
        subtitle.setTextFill(Color.GRAY);

        VBox header = new VBox(title, subtitle);
        header.setSpacing(5);

        HBox statsBox = new HBox(20);
        statsBox.getChildren().addAll(
                createStatCard("\uD83D\uDC65 Total Customers", "12,340", "#E4E4FA"),
                createStatCard("\u2705 Active Customers", "9,280", "#D6F5D6"),
                createStatCard("\uD83D\uDD34 Inactive Customers", "2,100", "#FAD6D6"),
                createStatCard("\uD83D\uDCC5 New This Month", "960", "#FEF6D6"));

        TextField searchField = new TextField();
        searchField.setPromptText("Search customers...");
        searchField.setPrefWidth(300);

        Button addCustomerBtn = new Button("Add Customer");
        addCustomerBtn.setStyle("-fx-background-color: #007bff; -fx-text-fill: white;");

        HBox searchBox = new HBox(10, searchField, addCustomerBtn);
        searchBox.setAlignment(Pos.CENTER_RIGHT);
        searchBox.setPadding(new Insets(10, 0, 0, 0));
        HBox.setHgrow(searchField, Priority.ALWAYS);

        TableView<Customer> table = new TableView<>();
        table.setPrefHeight(300);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Customer, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(data -> data.getValue().idProperty());

        TableColumn<Customer, String> nameCol = new TableColumn<>("NAME");
        nameCol.setCellValueFactory(data -> data.getValue().nameProperty());

        TableColumn<Customer, String> emailCol = new TableColumn<>("EMAIL");
        emailCol.setCellValueFactory(data -> data.getValue().emailProperty());

        TableColumn<Customer, String> statusCol = new TableColumn<>("STATUS");
        statusCol.setCellValueFactory(data -> data.getValue().statusProperty());

        TableColumn<Customer, String> dateCol = new TableColumn<>("JOIN DATE");
        dateCol.setCellValueFactory(data -> data.getValue().dateProperty());

        table.getColumns().addAll(idCol, nameCol, emailCol, statusCol, dateCol);
        table.setItems(getSampleCustomers());

        VBox container = new VBox(header, statsBox, searchBox, table);
        container.setSpacing(20);

        this.getChildren().add(container);
    }

    private VBox createStatCard(String labelText, String valueText, String bgColor) {
        Label label = new Label(labelText);
        label.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 13));
        label.setTextFill(Color.DIMGRAY);

        Label value = new Label(valueText);
        value.setFont(Font.font("Segoe UI", FontWeight.EXTRA_BOLD, 24));

        VBox card = new VBox(label, value);
        card.setPadding(new Insets(15));
        card.setSpacing(5);
        card.setStyle("-fx-background-color: " + bgColor + "; -fx-background-radius: 10;");
        card.setPrefWidth(180);

        return card;
    }

    private ObservableList<Customer> getSampleCustomers() {
        return FXCollections.observableArrayList(
                new Customer("1", "Krish Patel", "krish@example.com", "Active", "2023-01-10"),
                new Customer("2", "Ram Sharma", "ram@example.com", "Active", "2023-02-15"),
                new Customer("3", "Sneha Rao", "sneha@example.com", "Inactive", "2022-11-20"),
                new Customer("4", "Amit Verma", "amit@example.com", "Active", "2023-03-02"),
                new Customer("5", "Pooja Joshi", "pooja@example.com", "Active", "2023-04-18"),
                new Customer("6", "Neha Kulkarni", "neha@example.com", "Inactive", "2022-09-05"),
                new Customer("7", "Ravi Deshmukh", "ravi@example.com", "Active", "2023-05-12"),
                new Customer("8", "Tanvi Shah", "tanvi@example.com", "Active", "2023-06-22"),
                new Customer("9", "Jay Mehta", "jay@example.com", "Active", "2023-07-01"),
                new Customer("10", "Alisha Khan", "alisha@example.com", "Inactive", "2023-01-29"),
                new Customer("11", "Sameer Singh", "sameer@example.com", "Active", "2023-02-10"),
                new Customer("12", "Megha Nair", "megha@example.com", "Active", "2023-03-15"));
    }
}
