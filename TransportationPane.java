package com.admindashboard;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class TransportationPane extends VBox {

    public TransportationPane() {
        setSpacing(30);
        setPadding(new Insets(30));
        setStyle("-fx-background-color: #f5f5f5;");

        Label title = new Label("🚚 Transportation Overview");
        title.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");
        getChildren().add(title);

        GridPane productGrid = new GridPane();
        productGrid.setHgap(30);
        productGrid.setVgap(30);
        productGrid.setAlignment(Pos.CENTER);

        String[][] productData = {
                { "Apple", "apple.png", "Delivered", "Truck 14", "Arrived" },
                { "Carrot", "carrot.png", "On Route", "Van 02", "ETA: 1hr" },
                { "Banana", "banana.png", "Pending", "Bike 21", "ETA: 3hr" },
                { "Broccoli", "broccoli.png", "Delivered", "Truck 03", "Arrived" },
                { "Rice", "rice.png", "On Route", "Van 11", "ETA: 30min" },
                { "Tomato", "tomato.png", "On Route", "Van 07", "ETA: 50min" },
                { "Potato", "potato.png", "Pending", "Truck 05", "ETA: 2hr" }
        };

        for (int i = 0; i < productData.length; i++) {
            VBox card = createProductCard(productData[i]);
            productGrid.add(card, i % 3, i / 3);
        }

        getChildren().add(productGrid);
    }

    private VBox createProductCard(String[] data) {
        String name = data[0];
        String imagePath = data[1];
        String status = data[2];
        String vehicle = data[3];
        String eta = data[4];

        VBox box = new VBox(10);
        box.setPadding(new Insets(15));
        box.setAlignment(Pos.CENTER);
        box.setStyle(
                "-fx-background-color: #ffffff; -fx-border-radius: 15; -fx-background-radius: 15; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.15), 10, 0, 0, 5);");
        box.setPrefSize(220, 280);

        try {
            ImageView img = new ImageView(
                    new Image(getClass().getResourceAsStream("/images/" + imagePath)));
            img.setFitWidth(100);
            img.setFitHeight(100);
            box.getChildren().add(img);
        } catch (Exception e) {
            System.out.println("Error loading image: " + imagePath);
        }

        Label nameLabel = new Label(name);
        nameLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

        Label statusLabel = new Label("Status: " + status);
        String statusColor = switch (status.toLowerCase()) {
            case "delivered" -> "#27ae60";
            case "on route" -> "#f39c12";
            case "pending" -> "#e74c3c";
            default -> "#7f8c8d";
        };
        statusLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: " + statusColor + ";");

        Label vehicleLabel = new Label("Vehicle: " + vehicle);
        vehicleLabel.setStyle("-fx-font-size: 13px; -fx-text-fill: #34495e;");

        Label etaLabel = new Label("⏰ " + eta);
        etaLabel.setStyle("-fx-font-size: 13px; -fx-text-fill: #3498db;");

        box.getChildren().addAll(nameLabel, statusLabel, vehicleLabel, etaLabel);
        return box;
    }
}
