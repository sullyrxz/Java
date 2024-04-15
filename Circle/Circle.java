import java.lang.Comparable;
import java.lang.Math.*;

public class Circle extends GeometricObject implements Comparable {

    private double radius = 0;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public int compareTo(Object o) {
        Circle inpCircle = (Circle) o;
        if (this.radius == inpCircle.radius) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (compareTo(obj) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]) {
        Circle circle1 = new Circle(2.0);
        Circle circle2 = new Circle(1.45);
        Circle circle3 = new Circle(2.0);

        String str = "";

        str = "Circle 1 and Circle 2 " + (circle1.equals(circle2) ? "are " : "are not ") + "equal.";
        System.out.println(str);
        str = "Circle 1 and Circle 3 " + (circle1.equals(circle3) ? "are " : "are not ") + "equal.";
        System.out.println(str);
    }

}
