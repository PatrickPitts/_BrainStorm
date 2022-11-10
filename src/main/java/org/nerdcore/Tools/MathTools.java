package org.nerdcore.Tools;

public class MathTools {
    public static int average(int a, int b){
        return (a + b)/2;
    }

    public static double average(int a, int b, int c){
        return(a + b + c)/3.;
    }

    public static double average(int... ints){

        if(ints.length == 0)return 0;

        double a = 0;

        for(int n : ints){
            a += n;
        }
        return a / ints.length;
    }

    public static void dist(int x1, int x2, int y1, int y2){
        double val = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println(String.format("Distance is %s", val));
    }
}
