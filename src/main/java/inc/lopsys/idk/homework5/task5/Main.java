package inc.lopsys.idk.homework5.task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String gosNumber = "М395АК763";
        String regex = "^[АВЕКМНОРСТУХ]\\d{3}[АВЕКМНОРСТУХ]{2}\\d{2,3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(gosNumber);

        if (matcher.matches()) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
