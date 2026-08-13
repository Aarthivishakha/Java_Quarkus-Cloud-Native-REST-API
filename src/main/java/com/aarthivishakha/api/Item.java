package com.aarthivishakha.api;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public class Item {
    public Long id;
    @NotBlank public String name;
    @DecimalMin("0.0") public double price;

    public Item() { }
    public Item(Long id, String name, double price) {
        this.id = id; this.name = name; this.price = price;
    }
}
