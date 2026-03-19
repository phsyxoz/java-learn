package inc.lopsys.idk.homework4.streamAPI.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("КОТ", Animal.Type.CAT, Animal.Sex.M, 1, 50, 5000, true));
        animals.add(new Animal("СОБАКА", Animal.Type.DOG, Animal.Sex.F, 1, 75, 15000, true));
        animals.add(new Animal("ГОЛУБЬ", Animal.Type.BIRD, Animal.Sex.M, 1, 15, 1000, false));
        animals.add(new Animal("КАРАСЬ", Animal.Type.FISH, Animal.Sex.M, 1, 10, 1500, false));
        animals.add(new Animal("ПАУК", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 200, true));
        animals.add(new Animal("ВОЛК", Animal.Type.DOG, Animal.Sex.F, 1, 150, 30000, true));
        animals.add(new Animal("ВОРОБЕЙ", Animal.Type.BIRD, Animal.Sex.F, 1, 10, 300, false));
        animals.add(new Animal("ПУМА", Animal.Type.CAT, Animal.Sex.F, 1, 160, 40000, true));

        Map<Animal.Sex, Long> sexCount = animals.stream()
            .collect(Collectors.groupingBy(
                Animal::sex,
                Collectors.counting()
            ));

        Optional<Map.Entry<Animal.Sex, Long>> maxSex = sexCount.entrySet().stream()
            .max(Map.Entry.comparingByValue());

        if (maxSex.isPresent()) {
            Map.Entry<Animal.Sex, Long> entry = maxSex.get();
            Animal.Sex sex = entry.getKey();
            Long count = entry.getValue();

            System.out.println("Больше животных пола: " + sex + " (" + count + " Особей)");
        } else {
            System.out.println("Список животных пуст");
        }

    }
}
