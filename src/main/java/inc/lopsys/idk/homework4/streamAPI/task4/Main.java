package inc.lopsys.idk.homework4.streamAPI.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("КОТ", Animal.Type.CAT, Animal.Sex.M, 1, 50, 5000, true));
        animals.add(new Animal("СОБАКА", Animal.Type.DOG, Animal.Sex.F, 1, 75, 15000, true));
        animals.add(new Animal("ГОЛУБЬ", Animal.Type.BIRD, Animal.Sex.F, 1, 15, 1000, false));
        animals.add(new Animal("КАРАСЬ", Animal.Type.FISH, Animal.Sex.F, 1, 10, 1500, false));
        animals.add(new Animal("ПАУК", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 200, true));
        animals.add(new Animal("ВОЛК", Animal.Type.DOG, Animal.Sex.M, 1, 150, 30000, true));
        animals.add(new Animal("ВОРОБЕЙ", Animal.Type.BIRD, Animal.Sex.M, 1, 10, 300, false));
        animals.add(new Animal("ПУМА", Animal.Type.CAT, Animal.Sex.F, 1, 160, 40000, true));

        OptionalInt maxLength = animals.stream()
            .mapToInt(animal -> animal.name().length())
            .max();

        if (maxLength.isPresent()) {
            List<Animal> longestNamedAnimals = animals.stream()
                .filter(animal -> animal.name().length() == maxLength.getAsInt())
                .collect(Collectors.toList());

            System.out.println("Животные с самым длинным именем (" + maxLength.getAsInt() + " Символов):");
            longestNamedAnimals.forEach(animal ->
                System.out.println(animal.name())
            );
        }
    }
}
