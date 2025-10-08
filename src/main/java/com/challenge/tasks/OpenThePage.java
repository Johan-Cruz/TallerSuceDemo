package com.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenThePage implements Task {
    private final String url;
    private OpenThePage(String url) { this.url = url; }
    public static OpenThePage at(String url) { return new OpenThePage(url); }
    @Override public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }
}
