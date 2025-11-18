package inc.lopsys.idk.homework3.task2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Main {
    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Rectangle(1, 1)),
            Arguments.of(new Square(1))
        };
    }
    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        rect.setWidth(20);
        rect.setHeight(10);

        assertThat(rect.calculateArea()).isEqualTo(200.0);
    }
}

class Rectangle {
    private int width;
    private int height;

    public Rectangle(int height, int width){
        this.height = height;
        this.width = width;
    }

    void setWidth(int width) {
        this.width = width;
    }

    void setHeight(int height) {
        this.height = height;
    }

    double calculateArea() {
        return width * height;
    }
}

class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }

    @Override
    void setWidth(int side) {
        super.setWidth(side);
    }

    @Override
    void setHeight(int side) {
        super.setHeight(side);
    }
}
