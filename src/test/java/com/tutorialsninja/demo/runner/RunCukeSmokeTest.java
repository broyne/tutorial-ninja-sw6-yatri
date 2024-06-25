package com.tutorialsninja.demo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/tutorialsninja/demo/steps",
        plugin = {
                "html:target/cucumber-reports/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:target/cucumber-reports/cucumber.json"
        },
        tags = "@smoke"

)
public class RunCukeSmokeTest extends AbstractTestNGCucumberTests {

}