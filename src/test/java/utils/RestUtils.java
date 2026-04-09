package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestUtils {

    private static Response response;

    static {
        RestAssured.baseURI = "https://api.trello.com";
        RestAssured.basePath = "/1";
    }

    public static Response getResponse() {
        return response;
    }

    public static void post(Object body, String endpoint) {
        System.out.println("\n=== POST " + endpoint + " ===");

        response = RestAssured
                .given()
                .log().all()
                .contentType("application/json")
                .body(body)
                .when()
                .post(endpoint);

        response.then().log().all();
    }

    public static void put(String endpoint) {
        System.out.println("\n=== PUT " + endpoint + " ===");

        response = RestAssured
                .given()
                .log().all()
                .when()
                .put(endpoint);

        response.then().log().all();
    }

    public static void delete(String endpoint) {
        System.out.println("\n=== DELETE " + endpoint + " ===");

        response = RestAssured
                .given()
                .log().all()
                .when()
                .delete(endpoint);

        response.then().log().all();
    }
}