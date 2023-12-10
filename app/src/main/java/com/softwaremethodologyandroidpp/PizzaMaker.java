package com.softwaremethodologyandroidpp;

/**
 * Class that manages types of pizza.
 *
 * @author Abhishek Thakare, Adhit Thakur.
 */
public class PizzaMaker {

    /**
     * Method that creating a pizza based on cases.
     */
    public static Pizza createPizza(String pizzaType) {
        return switch (pizzaType) {
            case "Deluxe" -> new Deluxe();
            case "Supreme" -> new Supreme();
            case "Meatzza" -> new Meatzza();
            case "Seafood" -> new Seafood();
            case "Pepperoni" -> new Pepperoni();
            case "Glizzy Goblin" -> new GlizzyGoblin();
            case "Poultry Party" -> new PoultryParty();
            case "Spicy Phenom" -> new SpicyPhenom();
            case "Veggie Lovers" -> new VeggieLovers();
            case "Stinky Sally" -> new StinkySally();
            default -> new BuildYourOwn();
        };
    }
}
