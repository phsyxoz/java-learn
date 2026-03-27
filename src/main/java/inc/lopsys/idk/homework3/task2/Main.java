package inc.lopsys.idk.homework3.task2;

//    Допустим, у вас есть классы Rectangle и Square с методами setWidth(...), setHeight(...) и calculateArea()
//    Найдите решение проблемы, удовлетворяющее следующим ограничениям:
//      Не нарушается математическая логика, то есть квадрат является прямоугольником с точки зрения типизации
//      При этом не нарушается принцип подстановки Лисков
//      Все так же присутствует понятие высоты и ширины, а также операция вычисления площади
//      Реализация класса Rectangle не должна предполагать существование класса Square, иными словами, не нарушен принцип открытости-закрытости
// Пояснение принципа Лисков: дочерний класс не должен изменять принцип работы родительского, не должна нарушаться логика

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Main {
    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Rectangle(5, 6)),
            Arguments.of(new Square(7))
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        Rectangle result = rect.setWidth(10).setHeight(20);

        assertThat(result.calculateArea()).isEqualTo(200.0);
    }
}
