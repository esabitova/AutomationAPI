package positive_cases;

import base_class.BaseTestClass;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.json.JSONObject;
import utils.Endpoints;
import utils.Specifications;


public class PositiveTests extends BaseTestClass {
    Specifications specifications = new Specifications();

    @Test
    void testGetUserLogin(){

        Response response = specifications.getSpecification()
                .param("username", "John")
                .param("password", "123456")
                .when()
                .get(Endpoints.USER_LOGIN)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
    }

    @Test
    void testPostNewPet(){
        JSONObject requestParams = new JSONObject();
        requestParams.put("id", "125");

        Response response = specifications.getSpecification()
                .and()
                .body(requestParams.toString())
                .when()
                .post(Endpoints.PET)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("125", response.jsonPath().getString("id"));
    }

    @Test
    void testUpdatePet(){
        JSONObject requestParams = new JSONObject();
        requestParams.put("id", "123");
        requestParams.put("name", "puppy");

        Response response = specifications.getSpecification()
                .and()
                .body(requestParams.toString())
                .when()
                .put(Endpoints.PET)
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("puppy", response.jsonPath().getString("name"));
    }
}
