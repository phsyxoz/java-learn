package inc.lopsys.idk.homework6.task2;

import java.io.*;
import java.nio.file.*;

public class CloneFile {
    public void cloneFile(Path path) throws IOException {
        if (!Files.exists(path)) {
            throw new IOException("Файл не найден: " + path);
        }

        String fileName = path.getFileName().toString();
        int dotIndex = fileName.lastIndexOf('.');
        String baseName;
        String extension;

        if (dotIndex > 0) {
            baseName = fileName.substring(0, dotIndex);
            extension = fileName.substring(dotIndex);
        }
        else {
            baseName = fileName;
            extension = "";
        }

        Path parent = path.toAbsolutePath().getParent();
        if (parent == null) {
            throw new IOException("Не удалось определить родительскую папку для файла: " + path);
        }

        String copyBaseName = baseName + " — копия";
        Path newPath;

        newPath = parent.resolve(copyBaseName + extension);
        if (!Files.exists(newPath)) {
        }
        else {
            int counter = 2;
            while (true) {
                newPath = parent.resolve(copyBaseName + " (" + counter + ")" + extension);
                if (!Files.exists(newPath)) {
                    break;
                }
                counter++;
            }
        }

        Files.copy(path, newPath, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Создана копия: " + newPath);
    }
}
