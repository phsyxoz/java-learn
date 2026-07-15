package inc.lopsys.idk.homework6.task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Path dir = Paths.get("C:\\Users\\steam\\Desktop\\java-tasks");

        if (!Files.exists(dir) || !Files.isDirectory(dir)) {
            System.out.println("Ошибка: Директория не найдена или путь не является папкой: " + dir.toAbsolutePath());
            return;
        }

        DirectoryStream.Filter<Path> filter = FileFilters.regularFile
            .and(FileFilters.readable)
            .and(FileFilters.largerThan(100))
            .and(FileFilters.magicNumber(0x89, 'P', 'N', 'G'))
            .and(FileFilters.globMatches("*.png"))
            .and(FileFilters.regexContains("java"));

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(dir, filter)) {
            boolean found = false;

            for (Path entry : entries) {
                found = true;
                System.out.println("Найден файл: " + entry.toAbsolutePath());

                long size = Files.size(entry);
                System.out.println("  Размер: " + size + " байт (" + (size / 1024) + " КБ)");
                System.out.println("--------------------------");
            }

            if (!found) {
                System.out.println("Файлы, соответствующие критериям, не найдены.");
            }

        } catch (IOException e) {
            System.err.println("Произошла ошибка при чтении директории: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
