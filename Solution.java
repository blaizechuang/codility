package com.example.user.testapp;

/**
 * Created by Blaize on 2017/10/19.
 */

public class Solution {

    public int[] CyclicRotation(int [] A, int K) {
        if (K == 0 || A.length == 0 || K % A.length == 0) {
            return A;
        }

        K = K % A.length;
        int [] array = new int [A.length];
        for (int i = 0; i< A.length; i++) {
            array[i] = (i < K) ? A[A.length + i - K] : A[i - K];
        }

        return array;
    }

    public int Binarygap(int N) {
        String binary = Integer.toBinaryString(N);
        int i = binary.length() - 1;
        while(binary.charAt(i) == '0') {
            i--;
        }

        int gap = 0;
        int counter = 0;
        for (; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                gap = Math.max(gap, counter);
                counter = 0;
            } else {
                counter++;
            }
        }
        return gap;
    }

    public int OddOccurrencesInArray(int[] A) {
        int value = 0;
        for (int i : A) {
            value ^= i;
        }
        return value;
    }

    public int FrogJmp(int X, int Y, int D) {
        return (int)Math.ceil((double)(Y-X)/D);
    }
}
