package com.challenge.tasks;

import com.challenge.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class LoginWith implements Task {
    private final String username;
    private final String password;
    private LoginWith(String username, String password) { this.username = username; this.password = password; }
    public static LoginWith credentials(String username, String password) { return new LoginWith(username, password); }
    @Override public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Enter.theValue(username).into(LoginPage.USERNAME),
            Enter.theValue(password).into(LoginPage.PASSWORD),
            Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}
