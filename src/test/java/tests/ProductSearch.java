package test.java.tests;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import io.restassured.http.ContentType;
import org.junit.runner.RunWith;
import static io.restassured.RestAssured.*;
import static test.java.tests.BaseTest.reqSpecification;

@RunWith(DataProviderRunner.class)
public class ProductSearch extends test.java.tests.BaseTest {

    @com.tngtech.java.junit.dataprovider.DataProvider
    public static Object[][] searchTerms() {
        return new Object[][] {
                { "Celular Motorola" },
                { "Pop its" },
                { "Playstation 5"}
        };
    }

    @Story("Testing Mercadolibre's search API with different keywords")
    @DisplayName("API Meli Search")
    @Test
    @UseDataProvider("searchTerms")
    public void testMercadolibreProductSearch(String searchTerm) {
        given().
                param("q", searchTerm).
                when().
                    get("/search").
                then().
                    assertThat().
                    statusCode(200).
                    contentType(ContentType.JSON).
                    log().body();
    }
}
