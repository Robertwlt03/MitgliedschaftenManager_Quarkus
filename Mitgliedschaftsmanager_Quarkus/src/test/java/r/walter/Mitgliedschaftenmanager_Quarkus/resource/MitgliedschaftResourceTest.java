package r.walter.Mitgliedschaftenmanager_Quarkus.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class MitgliedschaftResourceTest {
    @Test
    void home() {
        given()
                .when().get("/mitgliedschaften")
                .then()
                .statusCode(200);
    }
}
