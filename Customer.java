package com.admindashboard;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty email;
    private final StringProperty status;
    private final StringProperty date;

    public Customer(String id, String name, String email, String status, String date) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
        this.status = new SimpleStringProperty(status);
        this.date = new SimpleStringProperty(date);
    }

    public StringProperty idProperty() {
        return id;
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public StringProperty dateProperty() {
        return date;
    }
}
