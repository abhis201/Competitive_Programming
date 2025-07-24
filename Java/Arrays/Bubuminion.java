import java.util.Scanner;

public class Bubuminion {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();

        int arrA[] = new int[N];
        int arrB[] = new int[M];

        for(int i = 0; i<N; i++){
            arrA[i] = sc.nextInt();
        }

        int roti = 0;
        int sum = 0;
        int a=0,b=0;
        for(int j = 0; j<M; j++){
            arrB[j] = sc.nextInt();
            if(arrB[b]<=arrA[a]){
                sum += arrB[b++];
                if(sum<=K) roti++;
            }
        }

        int sum = 0;
        int i=0,j=0;
        int roti = 0;

        while(sum<K && i<N && j<M){
            if(arrA[i]<=arrB[j]){
                sum += arrA[i++];
                if (sum<=K) roti++;
            }
            else{
                sum += arrB[j++];
                if(sum<=K) roti++;
            }
        }

        if(sum<K){
            while(i<N){
                sum += arrA[i++];
                if(sum<=K) roti++;
            }

            while(j<M){
                sum += arrB[j++];
                if(sum<=K) roti++;
            }
        }

        System.out.println(roti);
    }
}
