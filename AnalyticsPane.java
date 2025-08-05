package com.admindashboard;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class AnalyticsPane extends BorderPane {

    public AnalyticsPane() {
        setPadding(new Insets(30));
        setStyle("-fx-background-color: linear-gradient(to bottom right, #f8f9fa, #e9ecef);");

        // Header
        Label title = new Label("📊 Sales & Usage Analytics Dashboard");
        title.setFont(Font.font("Segoe UI", FontWeight.EXTRA_BOLD, 28));
        title.setTextFill(Color.web("#212529"));

        // KPIs Section
        HBox kpiBox = new HBox(30);
        kpiBox.setAlignment(Pos.CENTER);
        kpiBox.setPadding(new Insets(20));
        kpiBox.getChildren().addAll(
                createStatCard("Total Revenue", "₹1,20,000", "#4CAF50"),
                createStatCard("Monthly Active Users", "12,500", "#2196F3"),
                createStatCard("Average Order Value", "₹450", "#FF9800"),
                createStatCard("Conversion Rate", "4.6%", "#9C27B0"));

        // Line chart for sales
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Month");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Revenue (₹)");

        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("📈 Monthly Sales Trend");
        lineChart.setLegendVisible(false);
        lineChart.setMinHeight(300);
        lineChart.setStyle("-fx-background-color: white; -fx-background-radius: 10;");

        XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
        dataSeries.getData().add(new XYChart.Data<>("Jan", 12000));
        dataSeries.getData().add(new XYChart.Data<>("Feb", 18000));
        dataSeries.getData().add(new XYChart.Data<>("Mar", 24000));
        dataSeries.getData().add(new XYChart.Data<>("Apr", 21000));
        dataSeries.getData().add(new XYChart.Data<>("May", 27000));
        dataSeries.getData().add(new XYChart.Data<>("Jun", 32000));
        lineChart.getData().add(dataSeries);

        // Pie Chart for product category distribution
        PieChart pieChart = new PieChart();
        pieChart.setTitle("🛒 Product Category Split");
        pieChart.getData().add(new PieChart.Data("Groceries", 35));
        pieChart.getData().add(new PieChart.Data("Vegetables", 25));
        pieChart.getData().add(new PieChart.Data("Fruits", 20));
        pieChart.getData().add(new PieChart.Data("Dairy", 15));
        pieChart.getData().add(new PieChart.Data("Others", 5));
        pieChart.setMinHeight(250);
        pieChart.setClockwise(true);
        pieChart.setLabelsVisible(true);

        // Optional Image (if exists)
        ImageView analyticsImage;
        try {
            Image image = new Image(
                    "file:/C:/Users/DELL/OneDrive/Desktop/javafxprojectdemo/admindashboard/src/main/resources/images/analytics_image.jpg");
            analyticsImage = new ImageView(image);
            analyticsImage.setFitWidth(250);
            analyticsImage.setPreserveRatio(true);
        } catch (Exception e) {
            analyticsImage = new ImageView(); // fallback to empty
        }

        VBox leftBox = new VBox(20, analyticsImage, pieChart);
        leftBox.setAlignment(Pos.TOP_CENTER);

        VBox rightBox = new VBox(20, lineChart);
        rightBox.setAlignment(Pos.TOP_CENTER);
        rightBox.setPrefWidth(700);

        HBox centerBox = new HBox(40, leftBox, rightBox);
        centerBox.setPadding(new Insets(30));

        VBox contentBox = new VBox(20, title, kpiBox, centerBox);
        contentBox.setPadding(new Insets(20));
        contentBox.setStyle(
                "-fx-background-color: white; -fx-background-radius: 12; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.05), 10, 0, 0, 5);");

        setCenter(contentBox);
    }

    private VBox createStatCard(String title, String value, String colorHex) {
        Label titleLabel = new Label(title);
        titleLabel.setFont(Font.font("Segoe UI", FontWeight.SEMI_BOLD, 16));
        titleLabel.setTextFill(Color.web("#495057"));

        Label valueLabel = new Label(value);
        valueLabel.setFont(Font.font("Segoe UI", FontWeight.BOLD, 24));
        valueLabel.setTextFill(Color.web(colorHex));

        VBox box = new VBox(5, titleLabel, valueLabel);
        box.setPadding(new Insets(20));
        box.setStyle(
                "-fx-background-color: #ffffff; -fx-background-radius: 12; -fx-border-color: #dee2e6; -fx-border-radius: 12;");
        box.setAlignment(Pos.CENTER);
        box.setPrefWidth(180);
        return box;
    }
}
