package liveProject;


import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {

    //Declare Headers

    Map<String, String> headers = new HashMap<>()


    //Create Pact
    @Pact(consumer = 'UserConsumer', provider = 'UserProvider')
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        //headers

        headers.put("Content-Type", "application/json");

        //Request and Response Body

        DslPart requestResponseBody = new PactDslJsonBody().
         numberType("id", 123).
         stringType("firstName", "Ravi").
         stringType("lastName", "Sankar").
         stringType("email", "ravi@example.com");



        //Generate Contact

        return builder.given("POST Request").
                uponReceiving("request to create a user").
                 method("POST").
                 path("/api/users").
                 headers(headers).
                 body("requestResponseBody").
                willRespondWith().
                 status(200).
                 body("requestResonseBody").
                toPact();
    }

    //Test with mock provider

       @Test
       @PactTestFor(providerName = "UserProvider", port = "8282")
       public void consumerTest(){

        //Request Body
           Map<String, Object> reqBody = new HashMap<>();
            reqBody.put("id", 123);
            reqBody.put("firstName", "Ravi");
            reqBody.put("lastName", "Sankar");
            reqBody.put("email", "ravi@example.com");



        //Send request
         given().header(headers).body(reqBody).log().all().
         when().post("http://localhost:8282/api/users").
         then().statusCode(200).body("firstName", equalTo("Ravi")).log().all();


       }

}
