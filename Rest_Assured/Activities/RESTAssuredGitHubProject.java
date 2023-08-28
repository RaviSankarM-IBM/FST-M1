package RESTAssuredGitHubProject;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RESTAssuredGitHubProject {
    //Declare request specification
    RequestSpecification requestSpec;
    int keyId;
    String Authorization = "Bearer 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";


    // Declare response specification
    ResponseSpecification responseSpec;

    @BeforeClass
    public void setUp() {
        // Create request specification
        requestSpec = new RequestSpecBuilder()
                // Set content type
                .setContentType(ContentType.JSON)
                //Authorization header that has the value "token <GitHub access token>"
                .addHeader("Authorization", Authorization)
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
                // Check if response contains name property
                //.expectBody("status", equalTo("alive"))
                // Build response specification
                .build();
    }

    @Test(priority = 1)
    public void postToken(){

        String reqBody = "{\"title\": TestAPIKey, \"key\": \"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\"}";
        Response response = given().spec(requestSpec) // Use requestSpec
                .body(reqBody) // Send request body
                .when().post( "/user/keys"); // Send POST request

        keyId = response.then().extract().path("id");

        System.out.println(response.asPrettyString());

        //Assertion
        response.then().spec(responseSpec).statusCode(201);


    }

    @Test(priority = 2)
    public void getToken(){

        Response response = given().spec(requestSpec) // Use requestSpec
                .pathParam("keyId", keyId) // Add path parameter
                .when().get( "/user/keys/{keyId}"); // Send GET request

        System.out.println(response.asPrettyString());

        response.then().spec(responseSpec).statusCode(200);

    }

    @Test(priority = 3)
    public void deleteToken(){

        Response response = given().spec(requestSpec) // Use requestSpec
                .pathParam("keyId", keyId) // Add path parameter
                .when().delete( "/user/keys/{keyId}"); // Send GET request


        System.out.println(response.asPrettyString());

        // Assertions
        response.then().body("code", equalTo(200));

    }


}
