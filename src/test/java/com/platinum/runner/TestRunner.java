package com.platinum.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.platinum.steps",
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class TestRunner {
}
