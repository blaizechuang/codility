package com.example.user.testapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    /**
    Performance only 60%
     */
    public int PermMissingElem(int[] A) {
        int N = A.length + 1;
        int total = N*(N+1)/2;
        if (total > Integer.MAX_VALUE) {
            return 1;
        }
        for (int i = 0; i < A.length; i++) {
            total -= A[i];
        }

        return total;
    }

    public int TapeEquilibrium(int[] A) {
        if (A.length == 0) {
            return 0;
        } else if (A.length == 1) {
            return A[0];
        }

        int[] lArr = new int[A.length - 1];
        for (int i = 0; i < A.length - 1; i++) {
            if (i == 0) {
                lArr[i] = A[i];
            } else {
                lArr[i] = A[i] + lArr[i - 1];
            }
        }

        int[] rArr = new int[A.length - 1];
        for (int j = A.length - 1; j > 0; j--) {
            if (j == A.length - 1) {
                rArr[j - 1] = A[j];
            } else {
                rArr[j - 1] = A[j] + rArr[j];
            }
        }

        int value = Integer.MAX_VALUE;
        for (int k = 0; k < rArr.length; k++) {
            value = Math.min(value, Math.abs(lArr[k] - rArr[k]));
        }

        return value;
    }

    public int PermCheck(int[] A) {
        int N = A.length;
        boolean[] valid = new boolean[N+1];
        for (int index : A)
            if (index > N)
                return 0;
            else
                valid[index] = true;
        for (int i = 1; i <= N; i++) {
            if (!valid[i])
                return 0;
        }
        return 1;
    }

    public int FrogRiverOne(int X, int[] A) {
        int[] resultArray = new int[X + 1];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = 1;
        }

        int sum = resultArray.length;
        int finalStep = 0;
        for (int i = 0; i < A.length; i++) {
            if (resultArray[A[i]] == 1) {
                resultArray[A[i]] = 0;
                sum--;
                if (sum == 1) {
                    finalStep = i;
                    break;
                }
            }
        }

        return (sum == 1) ? finalStep : -1;
    }

    public int MissingInteger(int[] A) {
        if (A.length == 1 && A[0] == 1) {
            return 2;
        } else if (A.length == 1 && A[0] != 1) {
            return 1;
        }

        Arrays.sort(A);

        int min = 0;
        for(int i : A) {
            if (min + 1 == i) {
                min = i;
            }
        }

        return min + 1;
    }

    public int CountDiv(int A, int B, int K) {
        int count = B/K - A/K;
        if (A%K == 0) {
            count++;
        }
        return count;
    }

    public int MinAvgTwoSlice(int[] A) {
        double min = Integer.MAX_VALUE, tmp_2, tmp_3 = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i< A.length - 1; i++) {
            tmp_2 = (A[i] + A[i + 1])/2.0;
            if (i < A.length - 2) {
                tmp_3 = (A[i] + A[i + 1] + A[i + 2])/3.0;
            }
            if (min > Math.min(tmp_2, tmp_3)) {
                min = Math.min(tmp_2, tmp_3);
                index = i;
            }
        }
        return index;
    }
}
