package inc.lopsys.idk.homework4.streamAPI.task17;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

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

        long totalDogs = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG)
            .count();

        long bitingDogs = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG && animal.bites())
            .count();

        long totalSpiders = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER)
            .count();

        long bitingSpiders = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER && animal.bites())
            .count();

        if (totalDogs == 0 || totalSpiders == 0) {
            return false;
        }

        double dogBitingRatio = (double) bitingDogs / totalDogs;
        double spiderBitingRatio = (double) bitingSpiders / totalSpiders;

        return spiderBitingRatio > dogBitingRatio;
    }
}
