package client;

import io.restassured.response.Response;
import model.Product;
import util.RequestSpecFactory;

import static io.restassured.RestAssured.given;

public class ProductClient {

    public Response getAllProducts() {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .when()
                .get("/api/productsList");
    }

    public Response createProduct(Product product) {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .body(product)
                .when()
                .post("/product");
    }

    public Response getProduct(int productId) {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .pathParam("productId", productId)
                .when()
                .get("/product/{productId}");
    }

    public Response updateProduct(Product product) {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .body(product)
                .when()
                .put("/product");
    }

    public Response deleteProduct(int productId) {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .pathParam("productId", productId)
                .when()
                .delete("/product/{productId}");
    }

    public Response searchProduct(String searchProduct) {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .queryParam("search_product", searchProduct)
                .when()
                .post("/api/searchProduct");
    }
}