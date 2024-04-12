import java.util.Scanner;

class Triangle extends GeometricObject {

    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    Triangle() {

    }

    Triangle(double side1, double side2, double side3) {

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    @Override
    public double getArea() {

        double perimeter = getPerimeter();
        return Math.sqrt(perimeter * ((perimeter - side1) *
                (perimeter - side2) *
                (perimeter - side3)));
    }

    @Override
    public double getPerimeter() {
        double perimeter = 0;

        perimeter += side1;
        perimeter += side2;
        perimeter += side3;

        return perimeter;
    }

    @Override
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }

    public static void main(String args[]) {

        double userSide1 = 0;
        double userSide2 = 0;
        double userSide3 = 0;
        String color = "";
        String fillStr = "";
        boolean filled = false;

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter side 1: ");
        userSide1 = Double.parseDouble(myObj.nextLine());
        System.out.println("Enter side 2: ");
        userSide2 = Double.parseDouble(myObj.nextLine());
        System.out.println("Enter side 3: ");
        userSide3 = Double.parseDouble(myObj.nextLine());
        System.out.println("Enter a color: ");
        color = myObj.nextLine()1;
        System.out.println("Fill(True | False): ");
        fillStr = myObj.nextLine();
        if (fillStr.toLowerCase().equals("true")) {
            filled = true;
        }

        Triangle triangle1 = new Triangle(userSide1, userSide2, userSide3);
        triangle1.setColor(color);
        triangle1.setFilled(filled);

        String outStr = "";

        outStr = String.format("Triangle Area : %f", triangle1.getArea());
        System.out.println(outStr);

        outStr = String.format("Triangle Perimiter : %f", triangle1.getPerimeter());
        System.out.println(outStr);

        outStr = String.format("Triangle Color : %s", triangle1.getColor());
        System.out.println(outStr);

        outStr = String.format("Triangle Fill : %s", filled ? "Filled" : "Not Filled");
        System.out.println(outStr);
    }

}
