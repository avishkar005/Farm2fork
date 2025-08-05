package com.admindashboard;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SettingsPane extends VBox {

    public SettingsPane() {
        this.setSpacing(25);
        this.setPadding(new Insets(30));
        this.setStyle("-fx-background-color: white;");

        Label title = new Label("⚙️ Settings");
        title.setFont(Font.font("Segoe UI", FontWeight.BOLD, 26));
        title.setTextFill(Color.web("#333"));

        Label subtitle = new Label("Manage application preferences and user controls");
        subtitle.setFont(Font.font("Segoe UI", 14));
        subtitle.setTextFill(Color.web("#666"));

        VBox header = new VBox(title, subtitle);
        header.setSpacing(5);

        // Settings Sections
        TitledPane accountPane = new TitledPane("👤 Account Settings", getAccountSettingsPane());
        TitledPane notificationPane = new TitledPane("🔔 Notifications", getNotificationPane());
        TitledPane securityPane = new TitledPane("🔒 Security", getSecurityPane());
        TitledPane themePane = new TitledPane("🎨 Theme Preferences", getThemePane());

        accountPane.setExpanded(false);
        notificationPane.setExpanded(false);
        securityPane.setExpanded(false);
        themePane.setExpanded(false);

        this.getChildren().addAll(header, accountPane, notificationPane, securityPane, themePane);
    }

    private VBox getAccountSettingsPane() {
        VBox box = new VBox(12);
        box.setPadding(new Insets(10));

        TextField nameField = new TextField();
        nameField.setPromptText("Full Name");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("New Password");

        Button updateBtn = new Button("Update Info");
        updateBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-padding: 8 20 8 20;");
        Tooltip.install(updateBtn, new Tooltip("Click to update your information"));

        box.getChildren().addAll(
                new Label("Name:"), nameField,
                new Label("Email:"), emailField,
                new Label("Change Password:"), passwordField,
                updateBtn);

        return box;
    }

    private VBox getNotificationPane() {
        VBox box = new VBox(10);
        box.setPadding(new Insets(10));

        CheckBox emailNotif = new CheckBox("Email Notifications");
        CheckBox smsNotif = new CheckBox("SMS Alerts");
        CheckBox pushNotif = new CheckBox("Push Notifications");

        box.getChildren().addAll(emailNotif, smsNotif, pushNotif);
        return box;
    }

    private VBox getSecurityPane() {
        VBox box = new VBox(10);
        box.setPadding(new Insets(10));

        CheckBox twoFA = new CheckBox("Enable Two-Factor Authentication");
        Label deviceInfo = new Label("Last login: Windows 10 – Pune, India");
        Label lastPwdUpdate = new Label("Password last changed: 15 days ago");

        box.getChildren().addAll(twoFA, deviceInfo, lastPwdUpdate);
        return box;
    }

    private VBox getThemePane() {
        VBox box = new VBox(10);
        box.setPadding(new Insets(10));

        ComboBox<String> themeSelect = new ComboBox<>();
        themeSelect.getItems().addAll("Light Mode", "Dark Mode", "System Default");
        themeSelect.setValue("Light Mode");

        ComboBox<String> fontSelect = new ComboBox<>();
        fontSelect.getItems().addAll("Segoe UI", "Arial", "Roboto");
        fontSelect.setValue("Segoe UI");

        box.getChildren().addAll(
                new Label("Select Theme:"), themeSelect,
                new Label("Font Style:"), fontSelect);
        return box;
    }

    // For independent testing only (optional)
    public static void main(String[] args) {
        javafx.application.Application.launch(SettingsApp.class);
    }

    public static class SettingsApp extends javafx.application.Application {
        @Override
        public void start(Stage primaryStage) {
            Scene scene = new Scene(new SettingsPane(), 600, 650);
            primaryStage.setTitle("Settings Page");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }
}
