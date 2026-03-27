package inc.lopsys.idk.homework3.task2;

public class Square extends Rectangle {

    public Square(int side) {
        super(side, side);
    }

    @Override
    public Rectangle setWidth(int width) {
        return new Rectangle(width, height);
    }

    @Override
    public Rectangle setHeight(int height) {
        return new Rectangle(width, height);
    }
}
