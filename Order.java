package com.admindashboard;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Order {
    private final StringProperty orderId;
    private final StringProperty customerName;
    private final StringProperty status;
    private final StringProperty amount;

    public Order(String orderId, String customerName, String status, String amount) {
        this.orderId = new SimpleStringProperty(orderId);
        this.customerName = new SimpleStringProperty(customerName);
        this.status = new SimpleStringProperty(status);
        this.amount = new SimpleStringProperty(amount);
    }

    public StringProperty orderIdProperty() {
        return orderId;
    }

    public StringProperty customerNameProperty() {
        return customerName;
    }

    public StringProperty statusProperty() {
        return status;
    }

    public StringProperty amountProperty() {
        return amount;
    }

    public String getCustomerName() {
        return customerName.get();
    }
}
