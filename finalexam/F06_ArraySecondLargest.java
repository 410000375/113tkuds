package finalexam;

import java.util.Scanner;

public class F06_ArraySecondLargest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Pair result = findSecondMax(arr, 0, n - 1);
        System.out.println("SecondMax: " + result.second);
        sc.close();
    }

    
    static class Pair {
        int max;
        int second;

        Pair(int max, int second) {
            this.max = max;
            this.second = second;
        }
    }

    static Pair findSecondMax(int[] arr, int left, int right) {
        if (left == right) {
            return new Pair(arr[left], Integer.MIN_VALUE);
        }

        int mid = (left + right) / 2;
        Pair leftPair = findSecondMax(arr, left, mid);
        Pair rightPair = findSecondMax(arr, mid + 1, right);

        int max, second;
        if (leftPair.max > rightPair.max) {
            max = leftPair.max;
            second = Math.max(leftPair.second, rightPair.max);
        } else {
            max = rightPair.max;
            second = Math.max(rightPair.second, leftPair.max);
        }
        return new Pair(max, second);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：使用 divide-and-conquer（分治法）遞迴拆分陣列並合併每段的最大與次大值，
 * 每個元素只處理一次，因此整體時間複雜度為 O(n)。
 */
