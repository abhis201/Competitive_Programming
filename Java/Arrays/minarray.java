import java.util.Scanner;

public class minarray {
    
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[] = new int[n];
        int rem[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            rem[i] = arr[i]%m;
        }

        int brr[] = new int[n];
        brr[0] = 0;
        int mx = 0;
        for(int i=1; i<n; i++){
            if(i<n-1 && rem[i]>rem[i-1]&& rem[i]<rem[i+1]){
                continue;
            }
            if(i<n-1 && rem[i]>rem[i-1]&& rem[i]>rem[i+1]){
                if(m-rem[i]+rem[i-1]>rem[i]-rem[i+1])
                brr[i] = rem[i+1]-rem[i];
                else{
                    brr[i] = m-rem[i]+rem[i-1];
                    rem[i] = rem[i-1];
                }
            }
            if(rem[i]<=rem[i-1]){
                brr[i] = rem[i-1]-rem[i];
                rem[i] = rem[i-1];
            }
            mx = Math.max(mx,brr[i]);
        }

        System.out.println(mx);

    }
}
