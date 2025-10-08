package com.challenge.tasks;

import com.challenge.userinterfaces.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProducts implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InventoryPage.ADD_BIKE_LIGHT),
                Click.on(InventoryPage.ADD_FLEECE_JACKET),
                Click.on(InventoryPage.CART_LINK)
        );
    }

    public static AddProducts toCart() {
        return instrumented(AddProducts.class);
    }
}
