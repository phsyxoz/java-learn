package inc.lopsys.idk.homework6.task3;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.regex.Pattern;

public class FileFilters implements AbstractFilter {

    public static final AbstractFilter regularFile = Files::isRegularFile;
    public static final AbstractFilter readable = Files::isReadable;
    public static final AbstractFilter writable = Files::isWritable;

    public static AbstractFilter largerThan(long size) {
        return path -> {
            try {
                return Files.size(path) > size;
            } catch (IOException e) {
                return false;
            }
        };
    }

    public static AbstractFilter withExtension(String extension) {
        if (!extension.startsWith(".")) {
            extension = "." + extension;
        }
        String finalExt = extension.toLowerCase();
        return path -> {
            String fileName = path.getFileName().toString().toLowerCase();
            return fileName.endsWith(finalExt);
        };
    }

    public static AbstractFilter globMatches(String pattern) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);

        return path -> {
            try {
                return matcher.matches(path.getFileName());
            } catch (Exception e) {
                return false;
            }
        };
    }

    public static AbstractFilter regexContains(String regex) {
        var pattern = Pattern.compile(regex);
        return path -> pattern.matcher(path.getFileName().toString()).find();
    }

    public static AbstractFilter magicNumber(byte... signature) {
        return path -> {
            try {
                byte[] buffer = new byte[signature.length];
                var inputStream = Files.newInputStream(path);
                try {
                    int read = inputStream.read(buffer);
                    if (read != signature.length) return false;
                    for (int i = 0; i < signature.length; i++) {
                        if (buffer[i] != signature[i]) return false;
                    }
                    return true;
                } finally {
                    inputStream.close();
                }
            } catch (IOException e) {
                return false;
            }
        };
    }

    @SafeVarargs
    public static AbstractFilter magicNumber(int... values) {
        byte[] signature = new byte[values.length];
        for (int i = 0; i < values.length; i++) {
            signature[i] = (byte) values[i];
        }
        return magicNumber(signature);
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        return true;
    }
}
