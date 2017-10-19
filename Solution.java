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
}
