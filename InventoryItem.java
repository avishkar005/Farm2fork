
package com.admindashboard;

public class InventoryItem {
    private String category;
    private String name;
    private String quantity;

    public InventoryItem(String category, String name, String quantity) {
        this.category = category;
        this.name = name;
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }
}
