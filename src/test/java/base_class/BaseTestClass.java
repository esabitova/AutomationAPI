package base_class;

import io.restassured.RestAssured;

import org.junit.jupiter.api.BeforeAll;
import utils.PropertiesLoader;

public class BaseTestClass {

    @BeforeAll
    static void getConfig(){
        RestAssured.baseURI = PropertiesLoader.loadProperty("base_url");
    }
}
