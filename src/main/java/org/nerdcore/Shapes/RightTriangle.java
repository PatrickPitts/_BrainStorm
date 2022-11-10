package org.nerdcore.Shapes;

public class RightTriangle extends ScaleneTriangle{
    public RightTriangle(double base, double height) {
        super(base, height, Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2)));
    }
}
