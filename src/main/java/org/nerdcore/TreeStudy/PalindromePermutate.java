package org.nerdcore.TreeStudy;

import java.util.HashMap;

public class PalindromePermutate {

    public static boolean check(String str){
        String check = str.toLowerCase();
        HashMap<Character, Integer> charMap = new HashMap<>();
        for(char c: check.toCharArray()){
            if(c != ' '){
                charMap.merge(c, 1, Integer::sum);
            }
        }
        int oddCount = 0;
        for(Integer n : charMap.values()){
            if(n%2 == 1)oddCount++;
        }
        return oddCount<=1;
    }
}
