package org.example;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features",
        glue = {"stepDefinitions"},
        tags = "@activity5"
)

public class Activities5Runner {}

