package inc.lopsys.idk.homework5.task4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String password = "YourP@ssword";
        String regex = "^[^\\s]*[~!@#$%^&*|][^\\s]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}

