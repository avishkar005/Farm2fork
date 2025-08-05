package com.admindashboard;

import javafx.geometry.Insets;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class InventoryPane extends VBox {
    public InventoryPane() {
        setPadding(new Insets(20));
        setSpacing(20);
        setStyle("-fx-background-color: #f7f7f7;");

        Label title = new Label("Inventory 📦");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 32));

        ComboBox<String> stockSelector = new ComboBox<>();
        stockSelector.getItems().addAll("Stock In", "Stock Out");
        stockSelector.setPromptText("Select Stock Type");

        HBox topControls = new HBox(20, title, stockSelector);
        topControls.setPadding(new Insets(10, 0, 10, 0));

        HBox cards = new HBox(20,
                createCard("Mangos In Stock", "120 kg", Color.GOLD),
                createCard("Bananas In Stock", "90 kg", Color.LIGHTGREEN),
                createCard("Oranges In Stock", "65 kg", Color.ORANGE),
                createCard("Damaged Items", "12 kg", Color.LIGHTCORAL),
                createCard("Out of Stock", "6 items", Color.LIGHTGRAY));

        LineChart<Number, Number> chart = createInventoryChart();
        TableView<InventoryItem> table = createInventoryTable();

        getChildren().addAll(topControls, cards, chart, table);
    }

    private VBox createCard(String label, String value, Color color) {
        VBox card = new VBox();
        card.setPadding(new Insets(15));
        card.setSpacing(8);
        card.setStyle("-fx-background-color: " + toHex(color)
                + "; -fx-background-radius: 10; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 6, 0, 0, 2);");

        Label lbl = new Label(label);
        lbl.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        lbl.setTextFill(Color.WHITE);

        Label val = new Label(value);
        val.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 22));
        val.setTextFill(Color.WHITE);

        card.getChildren().addAll(lbl, val);
        return card;
    }

    private LineChart<Number, Number> createInventoryChart() {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Item Trends");

        XYChart.Series<Number, Number> damaged = new XYChart.Series<>();
        damaged.setName("Damaged");
        damaged.getData().add(new XYChart.Data<>(0, 5));
        damaged.getData().add(new XYChart.Data<>(20, 10));
        damaged.getData().add(new XYChart.Data<>(40, 7));
        damaged.getData().add(new XYChart.Data<>(60, 13));
        damaged.getData().add(new XYChart.Data<>(80, 9));
        damaged.getData().add(new XYChart.Data<>(100, 15));

        XYChart.Series<Number, Number> stock = new XYChart.Series<>();
        stock.setName("Stock In");
        stock.getData().add(new XYChart.Data<>(0, 20));
        stock.getData().add(new XYChart.Data<>(20, 25));
        stock.getData().add(new XYChart.Data<>(40, 22));
        stock.getData().add(new XYChart.Data<>(60, 30));
        stock.getData().add(new XYChart.Data<>(80, 26));
        stock.getData().add(new XYChart.Data<>(100, 35));

        lineChart.getData().addAll(stock, damaged);
        return lineChart;
    }

    private TableView<InventoryItem> createInventoryTable() {
        TableView<InventoryItem> table = new TableView<>();
        table.setPlaceholder(new Label("No Inventory Data Available"));
        table.setPrefHeight(250);

        TableColumn<InventoryItem, String> form = new TableColumn<>("Category");
        TableColumn<InventoryItem, String> title = new TableColumn<>("Item Name");
        TableColumn<InventoryItem, String> digger = new TableColumn<>("Quantity");

        form.setPrefWidth(150);
        title.setPrefWidth(200);
        digger.setPrefWidth(120);

        form.setCellValueFactory(
                cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getCategory()));
        title.setCellValueFactory(
                cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getName()));
        digger.setCellValueFactory(
                cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getQuantity()));

        table.getColumns().addAll(form, title, digger);

        table.getItems().addAll(
                new InventoryItem("Fruit", "Mango", "120 kg"),
                new InventoryItem("Fruit", "Banana", "90 kg"),
                new InventoryItem("Fruit", "Orange", "65 kg"),
                new InventoryItem("Fruit", "Papaya", "40 kg"),
                new InventoryItem("Vegetable", "Potato", "75 kg"),
                new InventoryItem("Vegetable", "Tomato", "88 kg"),
                new InventoryItem("Grain", "Rice", "150 kg"),
                new InventoryItem("Grain", "Wheat", "130 kg"));

        return table;
    }

    private String toHex(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }
}
