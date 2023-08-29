package RESTAssuredGitHubProject;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.HashMap;
import java.util.Map;

public class RESTAssuredGitHubProjectTest {
    //Declare request specification
    RequestSpecification requestSpec;
    int keyId;

    String sshkey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIIm9cTqy4mQBHbgE74KQZWyty6m39hT1muXtNecXuDTj";

    // Declare response specification
    ResponseSpecification responseSpec;

    @BeforeClass
    public void setUp() {
        // Create request specification
        requestSpec = new RequestSpecBuilder()
                // Set content type
                //.setContentType(ContentType.JSON)
                .addHeader("Content-Type", "application/json")
                //Authorization header that has the value "token <GitHub access token>"
                .addHeader("Authorization", "token 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")
                // Set base URL
                //.setBaseUri("https://api.github.com/user/keys")
                .setBaseUri("https://api.github.com")
                // Build request specification
                .build();

       responseSpec = new ResponseSpecBuilder()
                // Check status code in response
                //.expectStatusCode(200)
                // Check response content type
                .expectContentType("application/json")
               .expectBody("key", equalTo(sshkey))
               .expectBody("title", equalTo("TestAPIKey"))
               .expectResponseTime(lessThan(4000L))
                // Check if response contains name property
                //.expectBody("status", equalTo("alive"))
                // Build response specification
                .build();
    }

    @Test(priority = 1)
    public void postTokenTest(){

        //String reqBody = "{\"title\": TestAPIKey, \"key\": sshkey}";
        Map<String, String> reqBody = new HashMap<>();
        reqBody.put("title", "TestAPIKey");
        reqBody.put("key", sshkey);


        Response response = given().spec(requestSpec) // Use requestSpec
                .body(reqBody) // Send request body
                .when().post("/user/keys"); // Send POST request

        keyId = response.then().extract().path("id");

        //Assertion
        response.then().statusCode(201).spec(responseSpec);


    }

    @Test(priority = 2)
    public void getTokenTest(){

        Response response = given().spec(requestSpec) // Use requestSpec
                .pathParam("keyId", keyId) // Add path parameter
                .when().get( "/user/keys/{keyId}"); // Send GET request

        response.then().spec(responseSpec).statusCode(200);

        System.out.println(response.asPrettyString());
    }

    @Test(priority = 3)
    public void deleteTokenTest(){

        Response response = given().spec(requestSpec) // Use requestSpec
                .pathParam("keyId", keyId) // Add path parameter
                .when().delete( "/user/keys/{keyId}"); // Send GET request


        // Assertions
        response.then().body("code", equalTo(200));

        System.out.println(response.asPrettyString());

    }


}
