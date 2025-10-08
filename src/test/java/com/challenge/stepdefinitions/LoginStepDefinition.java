package com.challenge.stepdefinitions;

import com.challenge.tasks.OpenThePage;
import com.challenge.tasks.LoginWith;
import com.challenge.userinterfaces.InventoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class LoginStepDefinition {

    @Managed(driver = "chrome")
    WebDriver browser;

    @Given("the user opens the SauceDemo website")
    public void openSite() {
        OnStage.theActorCalled("User").can(BrowseTheWeb.with(browser));
        OnStage.theActorInTheSpotlight().attemptsTo(OpenThePage.at("https://www.saucedemo.com/"));
    }

    @When("the user logs in with username {string} and password {string}")
    public void login(String username, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(LoginWith.credentials(username, password));
    }

    @Then("the inventory page should be displayed")
    public void verifyInventory() {
        OnStage.theActorInTheSpotlight().should(
                net.serenitybdd.screenplay.GivenWhenThen.seeThat(
                        WebElementQuestion.the(InventoryPage.INVENTORY_CONTAINER),
                        WebElementStateMatchers.isVisible()
                )
        );
    }
}
