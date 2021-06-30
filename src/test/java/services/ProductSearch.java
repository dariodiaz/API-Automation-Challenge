package test.java.services;

import org.junit.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class ProductSearch {

    @Test
    public void mercadolibreProductSearch() {
        given().
                when().
                    get("https://api.mercadolibre.com/sites/MLA/search?q=Motorola%20G6").
                then().
                    assertThat().
                    statusCode(200).
                and().
                    assertThat().
                    contentType(ContentType.JSON).
                and().
                    assertThat().
                    body("results[0].id", equalTo("MLA909570963"));
    }
}
