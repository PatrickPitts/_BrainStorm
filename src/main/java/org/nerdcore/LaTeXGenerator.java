package org.nerdcore;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Arrays;

public class LaTeXGenerator {

    private static final String LB = "\\\\\n";

    public static void main(String[] args) {
        String str = truthTable( 4,"p", "q", "r");


        toClipBoard(str);
    }

    public static void toClipBoard(String str){
        StringSelection S = new StringSelection(str);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(S, null);
    }

    /**
     * This private method takes in a String array representing the predicate statements for a truth table. When constructing
     * a truth table, we must consider every T/F permutation of those predicates. This method generates a 2D String Array
     * of all possible T/F permutations, such that the first column will have all T values for that predicate followed by
     * all F values. From there, the next predicate will have clustered T, then F values within the T/F clusters of the previous.
     *
     * @param statements
     * @return A 2d String Array of all permutations of T/F values for the given number of statements
     */
    private static String[][] predicateTruthValuePermutations(String... statements){
        int numRows = (int) Math.pow(2, statements.length);

        String[][] tvals = new String[numRows][statements.length];
        for(int i = 1; i <= statements.length; i++){
            String V = "F";
            for(int j = 0; j < numRows; j++){
                if(j % (int)Math.pow(2, i-1) == 0){
                    V = V.equals("T") ? "F" : "T";
                }
                tvals[j][statements.length - i] = V;
            }
        }
        return tvals;
    }


    /**
     * @param predicates
     * @return A formatted String that, when is used as input for a LaTeX editor, will correctly compile a default truth
     * table. This table will have filled in the possible T/F permutations for the antecedents, while leaving space
     */
    public static String truthTable(String... predicates){
        return truthTable(1, predicates);
    }


    public static String truthTable(int numAntecedents, String... predicates){
        StringBuilder sb = new StringBuilder(), antecedentFiller = new StringBuilder();
        String[] antecedents = new String[numAntecedents];
        Arrays.fill(antecedents, "(XxX)");
        sb.append("\\begin{center}\n\\begin{tabular}{");
        for(String s : predicates){
            sb.append("|c");
        }
        sb.append("|");
        for(String s : antecedents){
            sb.append("|c");
            antecedentFiller.append(" & \\_");
        }
        sb.append("|}\n\\hline\n");

        sb.append(String.join(" & ", predicates)).append(" & ").append(String.join(" & ", antecedents));
        sb.append(LB).append("\\hline\n");
        sb.append("%replace the \\_ with the truth values of antecedents\n");
        for(String[] row : predicateTruthValuePermutations(predicates)){
            sb.append(String.join(" & ", row)).append(antecedentFiller).append(LB);
        }

        sb.append("\\hline\n");
        sb.append("\\end{tabular}\n\\end{center}");

        return sb.toString();
    }
}
