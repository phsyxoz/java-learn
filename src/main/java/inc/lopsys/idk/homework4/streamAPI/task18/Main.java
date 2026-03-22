package inc.lopsys.idk.homework4.streamAPI.task18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<Animal> animals2 = new ArrayList<>();

        animals.add(new Animal("КОТ", Animal.Type.CAT, Animal.Sex.M, 5, 50, 5000, true));
        animals.add(new Animal("СОБАКА", Animal.Type.DOG, Animal.Sex.F, 7, 75, 15000, true));
        animals.add(new Animal("ГОЛУБЬ", Animal.Type.BIRD, Animal.Sex.M, 2, 15, 1000, false));
        animals.add(new Animal("КАРАСЬ", Animal.Type.FISH, Animal.Sex.M, 3, 10, 1500, false));
        animals.add(new Animal("ПАУК", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 200, true));
        animals.add(new Animal("ВОЛК", Animal.Type.DOG, Animal.Sex.M, 10, 150, 30000, true));
        animals.add(new Animal("ВОРОБЕЙ", Animal.Type.BIRD, Animal.Sex.M, 1, 10, 300, false));
        animals.add(new Animal("ПУМА", Animal.Type.CAT, Animal.Sex.F, 10, 160, 40000, true));
        animals2.add(new Animal("ЩУКА", Animal.Type.FISH, Animal.Sex.F, 3, 50, 3000, true));

        List<List<Animal>> allAnimalLists = Arrays.asList(animals, animals2);
        Optional<Animal> heaviestFish = allAnimalLists.stream()
            .flatMap(List::stream)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparing(Animal::weight));

        System.out.println("Самая тяжёлая рыба во всех списках:");
        if (heaviestFish.isPresent()) {
            Animal fish = heaviestFish.get();
            System.out.println(fish.name() + " (" + fish.weight() + " г.)");
        } else {
            System.out.println("Нет рыб в списках.");
        }
    }
}
