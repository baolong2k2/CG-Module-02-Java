public class FactoryDemo {
    public static void main(String[] args) {
        FactoryAnimal factoryAnimal = new FactoryAnimal();
        Animal dog = factoryAnimal.getAnimal("Feline");
        System.out.println("dog sound: " + dog.makeSound());

        Animal cat = factoryAnimal.getAnimal("canine");
        System.out.println("cat sound: " + cat.makeSound());
    }
}