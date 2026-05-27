package com.mk.java.dp;

public class LongestCommonSubsequence {

     public static void main(String[] args) {
         String s1 = "abcde";
         String s2 = "ace";

         System.out.println("Length of LCS is " + lcsRecursive(s1.length() - 1, s2.length() - 1, s1, s2));
     }



    static int lcsRecursive(int i, int j, String s1, String s2) {
        if (i < 0 || j < 0) return 0;

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + lcsRecursive(i - 1, j - 1, s1, s2);
        }

        return Math.max(
                lcsRecursive(i - 1, j, s1, s2),
                lcsRecursive(i, j - 1, s1, s2)
        );
    }



}
