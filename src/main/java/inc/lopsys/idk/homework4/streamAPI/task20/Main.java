package inc.lopsys.idk.homework4.streamAPI.task20;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = List.of(
            new Animal("КОТ", Animal.Type.CAT, Animal.Sex.M, 5, 50, 5000, true),
            new Animal("СОБАКА", Animal.Type.DOG, Animal.Sex.F, 7, 75, 15000, true),
            new Animal("ГОЛУБЬ", Animal.Type.BIRD, Animal.Sex.M, 2, 15, 1000, false),
            new Animal("КАРАСЬ", Animal.Type.FISH, Animal.Sex.M, 3, 10, 1500, false),
            new Animal("ПАУК", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 200, true),
            new Animal("ВОЛК", Animal.Type.DOG, Animal.Sex.M, 10, 150, 30000, true),
            new Animal("ВОРОБЕЙ", Animal.Type.BIRD, Animal.Sex.M, 1, 10, 300, false),
            new Animal("ПУМА", Animal.Type.CAT, Animal.Sex.F, 10, 160, 40000, true)
        );

        List<Animal> animals2 = List.of(
            new Animal("ЩУКА", Animal.Type.FISH, Animal.Sex.F, 3, 50, 3000, true)
        );

        List<Animal> allAnimals = new ArrayList<>(animals);
        allAnimals.addAll(animals2);

        Map<String, String> animalsWithErrors =
            AnimalValidator.validateAnimals(allAnimals);

        if (animalsWithErrors.isEmpty()) {
            System.out.println("Ошибок не найдено!");
        } else {
            System.out.println("Животные с ошибками:");
            animalsWithErrors.entrySet().stream()
                .forEach(entry -> {
                    System.out.println("Животное: " + entry.getKey());
                    System.out.println("  Ошибки: " + entry.getValue());
                    System.out.println();
                });
        }
    }
}
