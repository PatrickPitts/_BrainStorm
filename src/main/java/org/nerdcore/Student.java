package org.nerdcore;

import java.util.ArrayList;

public class Student {
    private String n;
    private int s1, s2, s3, s4, s5;

    public Student(String n, int s1, int s2, int s3, int s4, int s5) {
        this.n = n;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.s5 = s5;
    }

    public String toString(){
        String ret = "%s\t%s\t%s\t%s\t%s\t%s\t";
        return String.format(ret, n, s1, s2, s3, s4, s5);
    }
}
