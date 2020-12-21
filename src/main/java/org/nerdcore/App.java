package org.nerdcore;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        int[] arr = TestSorts.randomConsecutiveIntArray(10, 1000000000);
        System.out.println(Arrays.toString(arr));
    }
}

class PrivateClass {
    private static String myPrivateString = "This is a private external string";

    private static void privateClassMethod() {
        System.out.println("I'm the private class method");
    }

    public static class Inner extends PrivateClass {

        Inner() {
            privateClassMethod();
        }
    }
}

class Solution {

    private static String str = "I'm a private String!";

    private Object myObject;
    private Class myObjectClass;

    Solution(Object o) {
        this.myObject = o;
        this.myObject = o.getClass();
    }

    boolean isInstanceOf(Object that){
        return that.getClass().getTypeName().equals(myObjectClass.getTypeName());
    }


    private void privateMethod() {
        System.out.println("I'm private");
    }


}

