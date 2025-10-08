package com.challenge.stepdefinitions;

import com.challenge.tasks.AddProducts;
import com.challenge.tasks.Checkout;
import com.challenge.tasks.LoginWith;
import com.challenge.tasks.OpenThePage;
import com.challenge.utilities.CsvToUserData;
import com.challenge.models.UserData;
import com.challenge.questions.ConfirmationMessageVisible;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class PurchaseStepDefinition {

    @Managed(driver = "chrome")
    WebDriver browser;

    @Given("the user has logged in successfully")
    public void loggedIn() {
        OnStage.theActorCalled("Buyer").can(BrowseTheWeb.with(browser));
        OnStage.theActorInTheSpotlight().attemptsTo(OpenThePage.at("https://www.saucedemo.com/"));
        List<UserData> users = CsvToUserData.readFromResource("/testdata/users.csv");
        UserData u = users.isEmpty() ? new UserData("standard_user","secret_sauce") : users.get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(LoginWith.credentials(u.getUsername(), u.getPassword()));
    }

    @When("the user adds the products to the cart")
    public void theUserAddsTheProductsToTheCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(AddProducts.toCart());
    }

    @When("the user completes the checkout process")
    public void completesCheckout() {
        OnStage.theActorInTheSpotlight().attemptsTo(Checkout.withData("Johan","Cruz","11001"));
    }

    @Then("the confirmation message {string} should be displayed")
    public void confirmationMessage(String expected) {
        String message = ConfirmationMessageVisible.text().answeredBy(OnStage.theActorInTheSpotlight());
        org.junit.Assert.assertTrue("Expected to contain: " + expected + " but was: " + message,
                message != null && message.contains(expected));
    }
}
