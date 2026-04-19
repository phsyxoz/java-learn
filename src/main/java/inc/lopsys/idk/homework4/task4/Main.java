/**
 * Список контактов
 * Напишите функцию сортировки, которая принимает массив имен, сортирует их по фамилии по возрастанию/убыванию (ASC/DESC)
 * и возвращает новый массив контактов с заданной сортировкой.
 * Замечания:
 * - если фамилия отсутствует, то нужно использовать имя
 * - возвращать нужно не строки, а объекты
 */

package inc.lopsys.idk.homework4.task4;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static List<Contact> sortContacts(List<String> contactString, boolean ascdesc) {
        List<Contact> contacts = contactString.stream()
            .map(Main::parseContacts)
            .collect(Collectors.toList());

        Comparator<Contact> comparator = (c1, c2) -> {
            String key1 = (c1.getLastName() != null) ? c1.getLastName() : c1.getFirstName();
            String key2 = (c2.getLastName() != null) ? c2.getLastName() : c2.getFirstName();
            return key1.compareTo(key2);
        };

        if (!ascdesc) {
            comparator = comparator.reversed();
        }

        return contacts.stream()
            .sorted(comparator)
            .collect(Collectors.toList());
    }

    private static Contact parseContacts(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            return new Contact("Unknown", null);
        }

        String[] parts = fullName.trim().split("\\s+");
        if (parts.length == 1) {
            return new Contact(parts[0], null);
        } else {
            String lastName = parts[parts.length - 1];
            String firstName = String.join(" ", Arrays.copyOf(parts, parts.length - 1));
            return new Contact(firstName, lastName);
        }
    }

    public static void main(String[] args) {
        List<String> contacts = Arrays.asList("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes", "Plato", "Immanuel Kant");

        System.out.println("По возрастанию (ASC):");
        List<Contact> sortedAsc = sortContacts(contacts, true);
        sortedAsc.forEach(System.out::println);

        System.out.println("\nПо убыванию (DESC):");
        List<Contact> sortedDesc = sortContacts(contacts, false);
        sortedDesc.forEach(System.out::println);
    }
}
