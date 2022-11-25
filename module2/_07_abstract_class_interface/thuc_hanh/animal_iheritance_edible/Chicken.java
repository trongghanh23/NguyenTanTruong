package _07_abstract_class_interface.thuc_hanh.animal_iheritance_edible;

public class Chicken extends Animal implements Edible{
    @Override
    public String makeSound() {
        return "chicken: cluck-cluck";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}
