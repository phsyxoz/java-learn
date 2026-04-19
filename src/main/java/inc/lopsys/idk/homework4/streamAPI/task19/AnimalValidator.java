package inc.lopsys.idk.homework4.streamAPI.task19;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AnimalValidator {

    public static Map<String, Set<ValidationError>> validateAnimals(List<Animal> animals) {
        Map<String, Set<ValidationError>> result = new HashMap<>();

        return animals.stream()
            .map(animal -> Map.entry(animal.name(), validateAnimal(animal)))
            .filter(entry -> !entry.getValue().isEmpty())
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue
            ));
    }

    private static Set<ValidationError> validateAnimal(Animal animal) {
        Set<ValidationError> errors = new HashSet<>();

        if (animal.name() == null || animal.name().trim().isEmpty()) {
            errors.add(new ValidationError("Имя не может быть пустым"));
        }

        if (animal.age() < 0) {
            errors.add(new ValidationError("Возраст не может быть отрицательным"));
        }

        if (animal.height() <= 0) {
            errors.add(new ValidationError("Рост должен быть положительным числом"));
        }

        if (animal.weight() <= 0) {
            errors.add(new ValidationError("Вес должен быть положительным числом"));
        }

        if (animal.sex() == null) {
            errors.add(new ValidationError("Пол не может быть null"));
        }

        if (animal.type() == null) {
            errors.add(new ValidationError("Тип не может быть null"));
        }

        return errors;
    }
}
