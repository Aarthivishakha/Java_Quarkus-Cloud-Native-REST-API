package com.aarthivishakha.api;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public record Item(Long id, @NotBlank String name, @DecimalMin("0.0") double price) { }
