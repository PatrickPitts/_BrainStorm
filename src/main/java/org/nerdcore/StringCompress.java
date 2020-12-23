package org.nerdcore;

public class StringCompress {

    public static String compress(String str){
        StringBuilder compressed = new StringBuilder();
        char currentChar = str.charAt(0);
        int charCount = 0;
        for(char c: str.toCharArray()){
            if(c == currentChar){
                charCount++;
            }else{
                compressed.append(currentChar).append(charCount);
                currentChar= c;
                charCount = 1;
            }
        }
        compressed.append(currentChar).append(charCount);
        return compressed.toString().length()> str.length() ? str : compressed.toString();
    }

}
