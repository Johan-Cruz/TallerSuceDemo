package com.challenge.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InventoryPage {
   /* public static final Target INVENTORY_CONTAINER =
            Target.the("inventory container").locatedBy("#inventory_container");

    public static Target addButtonFor(String productName) {
        return Target.the("add button for " + productName)
                .locatedBy("//div[@class='inventory_item']//div[@class='inventory_item_name' and contains(text(),'{0}')]/ancestor::div[@class='inventory_item']//button")
                .of(productName);
    }

    public static final Target ADD_BIKE_LIGHT =
            Target.the("Add to cart for Bike Light").locatedBy("#add-to-cart-sauce-labs-bike-light");

    public static final Target ADD_FLEECE_JACKET =
            Target.the("Add to cart for Fleece Jacket").locatedBy("#add-to-cart-sauce-labs-fleece-jacket");


    public static final Target CART_LINK = Target.the("shopping cart link").locatedBy("//a[@class='shopping_cart_link']");
*/
   public static final Target INVENTORY_CONTAINER =
           Target.the("inventory container").locatedBy("#inventory_container");
    public static final Target ADD_BIKE_LIGHT =
            Target.the("Add to cart for Bike Light").locatedBy("#add-to-cart-sauce-labs-bike-light");

    public static final Target ADD_FLEECE_JACKET =
            Target.the("Add to cart for Fleece Jacket").locatedBy("#add-to-cart-sauce-labs-fleece-jacket");

    public static final Target CART_LINK =
            Target.the("shopping cart link").locatedBy(".shopping_cart_link");
}
