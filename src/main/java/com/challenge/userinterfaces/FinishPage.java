package com.challenge.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class FinishPage {
    public static final Target COMPLETE_HEADER =
            Target.the("complete header").locatedBy("//h2[@class='complete-header' and contains(.,'Thank you')]");
}
