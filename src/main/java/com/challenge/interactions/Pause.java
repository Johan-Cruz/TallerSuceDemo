package com.challenge.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class Pause implements Interaction {
    private final long millis;
    private Pause(long millis) { this.millis = millis; }
    public static Pause forMs(long millis) { return new Pause(millis); }
    @Override public <T extends Actor> void performAs(T actor) {
        try { Thread.sleep(millis); } catch (InterruptedException ignored) {}
    }
}
