package inc.lopsys.idk.homework5.task6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String string = "achfdbaabgabcaabg";
        String regex = "abc";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

        if (matcher.find()) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
