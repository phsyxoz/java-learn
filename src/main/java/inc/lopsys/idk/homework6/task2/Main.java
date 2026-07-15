package inc.lopsys.idk.homework6.task2;

import java.io.*;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {
        CloneFile cloner = new CloneFile();

        try {
            Path file = Paths.get("Tinkoff Bank Biggest Secret.txt");

            cloner.cloneFile(file);
        } catch (IOException e) {
            System.err.println("Ошибка при копировании файла: " + e.getMessage());
        }
    }
}
