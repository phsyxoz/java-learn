package inc.lopsys.idk.homework4.streamAPI.task19;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        List<Animal> allAnimals = new ArrayList<>(animals);
        allAnimals.addAll(animals2);

        Map<String, Set<ValidationError>> animalsWithErrors =
            AnimalValidator.validateAnimals(allAnimals);

        if (animalsWithErrors.isEmpty()) {
            System.out.println("Ошибок не найдено!");
        } else {
            System.out.println("Животные с ошибками:");
            for (Map.Entry<String, Set<ValidationError>> entry : animalsWithErrors.entrySet()) {
                System.out.println("Животное: " + entry.getKey());
                for (ValidationError error : entry.getValue()) {
                    System.out.println("  - " + error);
                }
                System.out.println();
            }
        }
    }
}
