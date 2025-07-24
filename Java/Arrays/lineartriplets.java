import java.util.Scanner;

public class lineartriplets{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int ans = 0; 
        int m21 = 0;
        int m32 = 0;
        int start = 0;

        for(int i=0; i<=n-3; i++){
            int c21 = arr[i+1]%arr[i];
            int m1 = arr[i]/2;
            if(c21<=m1){
                m21 = c21;
            }
            else if(c21>m1){
                m21 = arr[i]-c21;
            }

            int c32 = arr[i+2]%arr[i+1];
            int m2 = arr[i+1]/2;
            if(c32<=m2){
                m32 = c32;
            }
            else if(c32>m2){
                m32 = arr[i+1]-c32;
            }

            if((m21+m32)>ans){
                ans = (m21+m32);
                start = i+1;
            }
        }

        System.out.println(start+" "+ans);
    }
}