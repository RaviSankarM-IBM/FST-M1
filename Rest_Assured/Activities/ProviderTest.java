package liveProject;


import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;

@Provider("UserProvider")
@PactFolder("target/pacts")


public class ProviderTest {
@BeforeEach()
    public void setUp(PactVerificationContext context) {

    HttpTestTarget Target = new HttpTestTarget("localhost",8585);
    context.setTarget(Target);


}

@TestTemplate
@ExtendWith(PactVerificationInvocationContextProvider.class)
    void pactTestTemplate(PactVerificationContext context){

    context.verifyInteraction();
}

@State("POST Request")
    public void postRequest(){

}

//@State("GET Request")
  //  public void getRequest(){

//}


}
