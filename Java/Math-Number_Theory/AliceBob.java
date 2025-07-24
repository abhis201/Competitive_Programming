import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AliceBob{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[] = new int[N];

        long ans = 1;

        for(int i=0; i<N; i++){

            arr[i] = sc.nextInt();
        }

        int mod = (int)1e9+7;
        for(int i=0; i<N; i++){
            ans *= (long)(arr[i]-i);
        }
        System.err.println(0%mod);
        System.out.println(ans%mod);
    }
}