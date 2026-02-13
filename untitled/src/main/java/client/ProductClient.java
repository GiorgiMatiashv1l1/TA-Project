package client;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
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

    public Response getAllProductsWithPost() {
        // API 2: POST to productsList returns 405 Method Not Allowed
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .when()
                .post("/api/productsList");
    }

    public Response getAllBrands() {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .when()
                .get("/api/brandsList");
    }

    public Response searchProduct(String productName) {
        return given()
                .spec(RequestSpecFactory.formDataSpec())
                .formParam("search_product", productName)
                .when()
                .post("/api/searchProduct");
    }

    public Response searchProductWithoutParam() {
        return given()
                .spec(RequestSpecFactory.formDataSpec())
                .when()
                .post("/api/searchProduct");
    }

    public Response createProduct(Product product) {
        RequestSpecification spec = given()
                .spec(RequestSpecFactory.formDataSpec());

        if (product.getName() != null)  spec = spec.formParam("name", product.getName());
        if (product.getPrice() != null) spec = spec.formParam("price", product.getPrice());
        if (product.getBrand() != null) spec = spec.formParam("brand", product.getBrand());
        if (product.getCategory() != null) {
            if (product.getCategory().getCategory() != null)
                spec = spec.formParam("category", product.getCategory().getCategory());
            if (product.getCategory().getUsertype() != null
                    && product.getCategory().getUsertype().getUsertype() != null)
                spec = spec.formParam("usertype", product.getCategory().getUsertype().getUsertype());
        }

        return spec.when().post("/api/createProduct");
    }

    public Response deleteProduct(String email, String password) {
        return given()
                .spec(RequestSpecFactory.formDataSpec())
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .delete("/api/deleteAccount");
    }

    public Response verifyLogin(String email, String password) {
        return given()
                .spec(RequestSpecFactory.formDataSpec())
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .post("/api/verifyLogin");
    }

    public Response verifyLoginWithInvalidDetails(String email, String password) {
        return given()
                .spec(RequestSpecFactory.formDataSpec())
                .formParam("email", email)
                .formParam("password", password)
                .when()
                .post("/api/verifyLogin");
    }

    public Response searchProduct(String searchProduct) {
        return given()
                .spec(RequestSpecFactory.defaultJsonSpec())
                .queryParam("search_product", searchProduct)
                .when()
                .post("/api/searchProduct");
    }
}
