package com.aarthivishakha.api;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import jakarta.inject.Inject;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@QuarkusTest
public class ItemResourceTest {
    @Inject ItemService service;
    @BeforeEach public void reset() { service.clear(); }
    @Test public void healthIsUp() { given().when().get("/health").then().statusCode(200).body("status", equalTo("UP")); }
    @Test public void itemLifecycleWorks() {
        given().contentType("application/json").body("{\"name\":\"Keyboard\",\"price\":99.5}")
            .when().post("/api/v1/items").then().statusCode(201).body("id", equalTo(1));
        given().when().get("/api/v1/items/1").then().statusCode(200).body("name", equalTo("Keyboard"));
        given().when().delete("/api/v1/items/1").then().statusCode(204);
        given().when().get("/api/v1/items/1").then().statusCode(404);
    }
}
