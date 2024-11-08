package com.dogapi.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // Localização dos arquivos de feature
    glue = {"com.dogapi.tests.steps"},         // Localização dos steps
    plugin = {"pretty", "html:target/cucumber-reports"},
    monochrome = true
)
public class RunCucumberTest {
}
