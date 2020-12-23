package org.nerdcore;

public class OneAway {

    public static boolean check(String str1, String str2){
        String longer, shorter;
        if(str1.length() > str2.length()){
            longer = str1; shorter = str2;
        } else {
            longer = str2; shorter = str1;
        }
        if(longer.length() - shorter.length() > 1){
            return false;
        }

        if(longer.length() == shorter.length()){
            int numDiff = 0;
            for(int i = 0; i < longer.length(); i++){
                if(longer.charAt(i) != shorter.charAt(i))numDiff++;
            }
            return numDiff < 2;
        }

        int offset = 0;
        for(int i = 0; i < shorter.length(); i++){
            if(longer.charAt(i + offset) != shorter.charAt(i)){
                offset++;
            }
            if(offset>1){
                return false;
            }
        }
        return true;
    }
}
