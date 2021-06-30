package test.java.tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    protected static RequestSpecification reqSpecification;

    @BeforeClass
    public static void initURL() {
        RestAssured.baseURI = "https://api.mercadolibre.com";
        RestAssured.basePath = "/sites/MLA/";
        /*reqSpecification = new RequestSpecBuilder().
                setBaseUri("https://api.mercadolibre.com").
                setBasePath("sites/MLA").
                build();*/
    }

    @AfterAll
    public void tearDown(){
        RestAssured.reset();
    }
}
