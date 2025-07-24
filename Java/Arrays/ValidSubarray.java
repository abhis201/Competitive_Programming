/*

Question Name: Even Length Subarray

Problem Statement

Antonio is given an array A of length N. A subarray is a continuous part of the array formed by removing some elements from the beginning and from the end of the array. The subarray may be empty.

Now an array is called VALID if all its elements are unique. For example [1,2,3] is a VALID array but [1,2,2] is an INVALID array.

The score of an array is the sum of all elements of the array.

Among all the possible even length VALID subarrays of the given array, Antonio wants to find the maximum score of subarray he can achieve.

*/

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ValidSubarray {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int arr[] = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        int res = 0;
        int ans = 0;
        Set<Integer> uniq = new HashSet<Integer>();
        for(int i = 0; (i+1)<N; i++){
            uniq.clear();
            res = 0;
            for(int j = i+1; j<N; j = j+2){
                if(!uniq.contains(arr[j-1]) && !uniq.contains(arr[j])){
                    res += arr[j-1];
                    uniq.add(arr[j-1]);
                    res += arr[j];
                    uniq.add(arr[j]);
                }
                else{
                    break;
                }
                ans = Math.max(res,ans);
            }
        }

        int prefix[] = new int[N];
        for(int i = 0; i<N; i++){
            
        }

        // 8
        // 1 2 3 4 5 6 7 8

        

        // int start = 0,end = 0;
        // while(end<N){
        //     if((end + 1)<N && !uniq.contains(arr[end]) && !uniq.contains(arr[end+1])){
        //         res += arr[end] + arr[end+1];
        //         uniq.add(arr[end]);
        //         uniq.add(arr[end+1]);
        //         end = end + 2;
        //         ans = Math.max(ans,res);
        //     }
        //     else{
        //         start++; //or same index + 1
        //         end = start;
        //         res = 0;
        //         uniq.clear();
        //     }
        // }

        System.out.print(ans);
    }
}
