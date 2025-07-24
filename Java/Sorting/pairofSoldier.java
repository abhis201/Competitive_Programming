import java.util.Arrays;
import java.util.Scanner;

public class pairofSoldier {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int X = sc.nextInt();

        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        int count = 0;
        Arrays.sort(arr);
        

        for(int i=N-1; i>0; i--){
            if(arr[i]*arr[i-1]<X)break;
            for(int j=i-1; j>=0; j--){
                if(arr[i]*arr[j]<X)break;
                if(arr[i]*arr[j]>=X){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
