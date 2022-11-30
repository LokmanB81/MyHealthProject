package API_Tests;

import base_url.MedunnaBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class VerifyPatientAPI extends MedunnaBaseUrl {

    @Test
    public void test01(){

        spec.pathParams("first","patients","second",315443);

        Response response=given().spec(spec).headers("Authorization", "Bearer " + generateToken())
                .when().get("/{first}/{second}");

        response.prettyPrint();




    }
}
