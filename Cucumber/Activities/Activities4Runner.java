package org.example;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        glue = {"stepDefinitions"},
        tags = "@activity4"
)

public class Activities4Runner {}

