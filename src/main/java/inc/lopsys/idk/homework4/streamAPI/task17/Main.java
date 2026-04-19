package inc.lopsys.idk.homework4.streamAPI.task17;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        boolean hasBite = biteOften(animals);
        if (hasBite) {
            System.out.println("Да, пауки кусают чаще собак.");
        } else {
            System.out.println("Нет, собаки кусают чаще пауков, или данных недостаточно.");
        }
    }

    public static boolean biteOften(List<Animal> animals) {

        Map<Animal.Type, Long> totalCounts = animals.stream()
            .collect(Collectors.groupingBy(
                Animal::type,
                Collectors.counting()
            ));

        Map<Animal.Type, Long> bitingCounts = animals.stream()
            .filter(Animal::bites)
            .collect(Collectors.groupingBy(
                Animal::type,
                Collectors.counting()
            ));

        Long totalDogs = totalCounts.getOrDefault(Animal.Type.DOG, 0L);
        Long bitingDogs = bitingCounts.getOrDefault(Animal.Type.DOG, 0L);
        Long totalSpiders = totalCounts.getOrDefault(Animal.Type.SPIDER, 0L);
        Long bitingSpiders = bitingCounts.getOrDefault(Animal.Type.SPIDER, 0L);

        if (totalDogs == 0 || totalSpiders == 0) {
            return false;
        }

        double dogBitingRatio = (double) bitingDogs / totalDogs;
        double spiderBitingRatio = (double) bitingSpiders / totalSpiders;

        return spiderBitingRatio > dogBitingRatio;
    }
}
