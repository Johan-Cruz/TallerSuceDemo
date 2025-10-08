package com.challenge.tasks;

import com.challenge.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Checkout implements Task {
    private final String first;
    private final String last;
    private final String zip;
    private Checkout(String first, String last, String zip) {
        this.first = first; this.last = last; this.zip = zip;
    }
    public static Checkout withData(String first, String last, String zip) { return new Checkout(first, last, zip); }
    @Override public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(CheckoutPage.CHECKOUT_BUTTON),
            Enter.theValue(first).into(CheckoutPage.FIRST_NAME),
            Enter.theValue(last).into(CheckoutPage.LAST_NAME),
            Enter.theValue(zip).into(CheckoutPage.POSTAL_CODE),
            Click.on(CheckoutPage.CONTINUE),
            Click.on(CheckoutPage.FINISH)
        );
    }
}
