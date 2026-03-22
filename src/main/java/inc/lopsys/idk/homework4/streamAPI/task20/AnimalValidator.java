package inc.lopsys.idk.homework4.streamAPI.task20;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnimalValidator {

    public static Map<String, String> validateAnimals(List<Animal> animals) {
        Map<String, String> result = new HashMap<>();

        for (Animal animal : animals) {
            Set<ValidationError> errors = validateAnimal(animal);
            if (!errors.isEmpty()) {
                String errorMessage = errors.stream()
                        .map(ValidationError::getMessage)
                        .reduce((e1, e2) -> e1 + ", " + e2)
                        .orElse("");
                result.put(animal.name(), errorMessage);
            }
        }

        return result;
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
