package inc.lopsys.idk.homework3.task2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.Assertions.assertThat;

public class Main {
    private static int side, width, height;

    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Rectangle(width, height)),
            Arguments.of(new Square(side))
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
    private int width, height;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
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
    public void setWidth(int width) {
        super.setWidth(width);
    }

    @Override
    public void setHeight(int width) {
        super.setHeight(width);
    }

}
