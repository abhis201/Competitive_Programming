import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class arrayequality {
    
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int T,N,M;
        T = sc.nextInt();
        while(T--!=0)
        {
            N = sc.nextInt();
            M = sc.nextInt();
            int[] arr = new int[N];
            for(int i =0; i<N; i++){
                arr[i] = sc.nextInt();
            }

           int segment = Integer.MAX_VALUE;
           int prev = 0;
           int days = 0;
           Set<Integer> nums= new HashSet<>();
           for(int i=0; i<N; i++){
            if(nums.contains(arr[i])) continue;
            else nums.add(arr[i]);
            for(int j=0; j<N; j++){
                
                if(arr[i]!=arr[j]) continue;
                if(j>0 && j<N && arr[j-1]!=arr[j]){
                    if(prev!=j){
                        if(j-1-prev>M){
                            if(j-1-prev%M==0) days += (j-1-prev)/M;
                            else days+= (j-1-prev)/M+1;
                        }
                        else days+=1;
                    }
                    prev = j;
                }
            }
            segment = Math.min(days,segment);
           }

           System.out.println(segment);
        }
    }
}
