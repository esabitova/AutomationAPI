package negative_cases;

import base_class.BaseTestClass;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.Endpoints;
import utils.Specifications;


public class NegativeTests extends BaseTestClass {
    Specifications specifications = new Specifications();

    @Test
    void testGetPetByIdNotFound(){
        Response response = specifications.getSpecification()
                .when()
                .get(Endpoints.PET_ID,0)
                .then()
                .extract().response();

        Assertions.assertEquals(404, response.statusCode());
        Assertions.assertEquals("Pet not found", response.jsonPath().get("message").toString());
    }

    @Test
    void testDeletePetNotFound(){
        Response response = specifications.getSpecification()
                .when()
                .delete(Endpoints.PET_ID, 126)
                .then()
                .extract().response();

        Assertions.assertEquals(404, response.statusCode());
    }
}
