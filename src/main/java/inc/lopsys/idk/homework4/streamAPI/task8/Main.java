package inc.lopsys.idk.homework4.streamAPI.task8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("КОТ", Animal.Type.CAT, Animal.Sex.M, 5, 50, 5000, true));
        animals.add(new Animal("СОБАКА", Animal.Type.DOG, Animal.Sex.F, 7, 75, 15000, true));
        animals.add(new Animal("ГОЛУБЬ", Animal.Type.BIRD, Animal.Sex.M, 2, 15, 1000, false));
        animals.add(new Animal("КАРАСЬ", Animal.Type.FISH, Animal.Sex.M, 3, 10, 1500, false));
        animals.add(new Animal("ПАУК", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 200, true));
        animals.add(new Animal("ВОЛК", Animal.Type.DOG, Animal.Sex.F, 10, 150, 30000, true));
        animals.add(new Animal("ВОРОБЕЙ", Animal.Type.BIRD, Animal.Sex.F, 1, 10, 300, false));
        animals.add(new Animal("ПУМА", Animal.Type.CAT, Animal.Sex.F, 10, 160, 40000, true));

        Optional<Animal> shortHeavyAnimal = animals.stream()
            .filter(animal -> animal.height() < 80)
            .max(Comparator.comparingInt(Animal::weight));

        if (shortHeavyAnimal.isPresent()) {
            Animal animal = shortHeavyAnimal.get();
            System.out.println("Самое тяжелое животное ниже 80 см: " + animal.name() + " (" + animal.height() + " см, " + animal.weight() + " г.)");
        }
        else {
            System.out.println("Нет животных ниже 80 см");
        }
    }
}
