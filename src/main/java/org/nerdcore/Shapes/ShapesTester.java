package org.nerdcore.Shapes;


import java.util.ArrayList;
import java.util.List;

public class ShapesTester {
    public static void main(String[] args) {

        Shape rect = new Rectangle(2.0, 3.0);
        Shape sqr = new Square(2.0);

        List<Shape> shapes = new ArrayList<>();
        shapes.add(rect);
        shapes.add(sqr);

        for(Shape s : shapes){
            System.out.println(s.getArea());
            System.out.println(s.getPerimeter());
        }

    }
}
