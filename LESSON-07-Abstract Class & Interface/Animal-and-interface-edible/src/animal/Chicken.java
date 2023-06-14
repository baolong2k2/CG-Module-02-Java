package animal;

import edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "HELLO I'M NHƯ";
    }

    @Override
    public String howToEat() {
        return "FRIED";
    }
}
