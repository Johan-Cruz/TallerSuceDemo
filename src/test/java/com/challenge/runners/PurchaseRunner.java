package com.challenge.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/purchase",
        glue = {"com.challenge.stepdefinitions", "com.challenge.hooks"},
        plugin = {"pretty"},
        tags = "@purchase",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class PurchaseRunner {}
