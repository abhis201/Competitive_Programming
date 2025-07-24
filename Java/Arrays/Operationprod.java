import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Operationprod {

    static int getsmallfact(int a, int b){
        long sum = 0;
        if(a>b) return getsmallfact(b,a);
        
        ArrayList<Integer> factarr = new ArrayList<>();
        int mul = a*b;
        for(int i=1; i<=mul; i++){
            if(mul%i==0){
                factarr.add(i);
            }
        }
        int size = factarr.size();
        if(size==2) return 0;
        
        int mid1 = factarr.get(size/2-1);
        int mid2 = factarr.get(size/2);
        if(size%2==1)
        mid1 = mid2 =  factarr.get(size/2);
        if(mid1!=a || mid2!=b){
            sum = sum-a-b+mid1+mid2;
            return (int) sum;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int arr[] = new int[s];
        long sum[] = {0};
        for(int i=0; i<s; i++){
            arr[i] = sc.nextInt();
            sum[0] += arr[i];
        }
        
        Set<Integer> set = new HashSet<>();
        boolean out = false;
        for(int i=0; i<s; i++){
            if(!set.contains(arr[i])) set.add(arr[i]);
            else continue;
            for(int j=i+1; j<s; j++){
                if(arr[i]==arr[j])continue;
                if(getsmallfact(arr[i], arr[j])>0){
                    // int max = 
                    out = true;
                    break;
                }
                if(out) break;
            }
        }

        System.out.println(sum[0]);

    }
}
