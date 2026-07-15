package inc.lopsys.idk.homework6.task4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

public class Main {
    public static void main(String[] args) {
        String text = "Programming is learned by writing programs. – Brian Kernighan";
        Path filePath = Paths.get("output.txt");

        try (
            OutputStream fileOutputStream = Files.newOutputStream(filePath);

            CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream, new CRC32());

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "UTF-8");

            PrintWriter printWriter = new PrintWriter(outputStreamWriter)
        ) {
            printWriter.println(text);

            if (printWriter.checkError()) {
                System.err.println("Произошла ошибка при записи в файл.");
            }

            long checksum = ((CheckedOutputStream) checkedOutputStream).getChecksum().getValue();
            System.out.println("Контрольная сумма (CRC32): " + checksum);

        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }
}
