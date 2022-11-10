package org.nerdcore.Shapes;

public class ScaleneTriangle extends Shape{
    private double a, b, c;

    public ScaleneTriangle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
    }
    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }
    public double getC() {
        return c;
    }
    public void setC(double c) {
        this.c = c;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt( s * ( s - getA() ) * ( s - getB() ) * ( s - getC() ) );
    }

    @Override
    public double getPerimeter() {
        int println = 0;
        return getA() + getB() + getC();
    }
}
