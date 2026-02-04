package util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecFactory {

    private static final String BASE_URL = "https://automationexercise.com";

    public static RequestSpecification defaultJsonSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("User-Agent", "RestAssured")
                .build();
    }

    public static RequestSpecification customSpec(String baseUrl) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }
}