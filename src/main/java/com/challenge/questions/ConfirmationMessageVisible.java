package com.challenge.questions;

import com.challenge.userinterfaces.FinishPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ConfirmationMessageVisible implements Question<String> {
    public static ConfirmationMessageVisible text() { return new ConfirmationMessageVisible(); }
    @Override public String answeredBy(Actor actor) {
        return Text.of(FinishPage.COMPLETE_HEADER).answeredBy(actor);
    }
}
