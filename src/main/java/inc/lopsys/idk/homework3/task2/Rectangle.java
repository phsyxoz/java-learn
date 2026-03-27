package inc.lopsys.idk.homework3.task2;

public class Rectangle {
    public final int width;
    public final int height;

    public Rectangle(int width,int height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle setWidth(int width) {
        return new Rectangle(width, height);
    }

    public Rectangle setHeight(int height) {
        return new Rectangle(width, height);
    }

    double calculateArea() {
        return width * height;
    }
}
