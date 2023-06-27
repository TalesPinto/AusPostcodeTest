package test;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestAusPost {

    @Test
    public void testStatusCodeTest(){

        given().header("auth-key", "bcde3931-5c1d-424c-ae3c-cc31433c1a91")
                .and().params("q", "Mascot")
                .and().params("state", "NSW")
                .when().get("https://digitalapi.auspost.com.au/postcode/search.json")
                .then().assertThat().statusCode(is(200));

    }

    @Test
    public void testPostcodeTest() {
        given()
                .header("auth-key", "bcde3931-5c1d-424c-ae3c-cc31433c1a91")
                .and().params("q", "Sydney")
                .and().params("state", "NSW")
                .when()
                .get("https://digitalapi.auspost.com.au/postcode/search.json")
                .then().assertThat().body("localities.locality[0].postcode", equalTo(2055));
    }
}
