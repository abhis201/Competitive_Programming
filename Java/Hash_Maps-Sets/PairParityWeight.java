/*
Question Name: Pair Parity Weight

Problem Statement

You are given an array of N elements. A subarray is a continuous part of the array formed by deleting 
some elements from the beginning and some from the end of the array.

We define the cost of a subarray as the number of unordered pairs of indexes (i,j) (here i<j) 
with the same value (A[i]=A[j]) and also has i%2 = j%2.

For example cost of [1,2,2,1,1] is 1, as A[1] = A[5] = 1 and 1%2 = 5%2 = 1.

Find the sum of costs of all subarrays of given array A.

*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class PairParityWeight {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int arr[] = new int[N];

        Map<Integer,LinkedList<Integer>> vals = new HashMap<Integer,LinkedList<Integer>>();

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
            if(vals.get(arr[i])==null)
            vals.put(arr[i],new LinkedList<>());
            vals.get(arr[i]).add(i);
        }

        int count = 0;

        for(int i = 0; i<N; i++){

            for(Integer in:vals.get(arr[i]))
            {
                if(in>i && i%2 == in%2){
                    count += N-in;
                }
            }

        }

        // int res = 0;
        // for(int i =0; (i+2)<N; i++){

        //     for(int j = i+2; j<N; j = j+2){
        //         if(arr[i] == arr[j]){
        //             res += N-j;
        //         }
        //     }
        // }

    
        System.out.println(count);
    }
}
