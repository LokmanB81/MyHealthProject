package API_Tests;

import base_url.MedunnaBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class VerifyDoctorTest extends MedunnaBaseUrl {

    @Test
    public void test01(){

        spec.pathParams("first","physicians","second",301016);

        Response response=given().spec(spec).headers("Authorization", "Bearer " + generateToken())
                .when().get("/{first}/{second}");

        response.prettyPrint();




    }
}
