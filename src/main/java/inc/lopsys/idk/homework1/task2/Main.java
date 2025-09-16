package inc.lopsys.idk.homework1.task2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите время: ");
        String mmss = in.nextLine();
            if (mmss.contains(":")) {
                String[] parts = mmss.split(":");
                    if (parts.length == 2) {
                        int mm = Integer.parseInt(parts[0]);
                        int ss = Integer.parseInt(parts[1]);

                        if (mm < 0 || ss < 0) {
                            System.out.print("Время не может вернуться обратно! :с");
                        }
                        else if (ss > 59) {
                            System.out.print("Секунд не может быть больше 59");
                        }
                        else {
                            int result = (60 * mm) + ss;
                            System.out.print("Время в секундах: " + result);
                        }
                    }
                    else {
                        System.out.print("Неверный формат времени! \nПодсказка: (Минуты:Секунды)");
                    }
            }
            else {
                System.out.print("Неверный формат времени! \nПодсказка: (Минуты:Секунды)");
            }

        in.close();
    }
}
