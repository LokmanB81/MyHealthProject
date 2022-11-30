package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import utilities.Authentication;

public class MedunnaBaseUrl extends Authentication {

    protected RequestSpecification spec;

    @Before
    public void setup() {

        spec = new RequestSpecBuilder().setBaseUri("https://medunna.com/api/").build();
    }
}
