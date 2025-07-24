import java.util.Scanner;

public class bubblesort {

    static int bubblesteps(int[] arr, int N){

        int x = 0;
        for(int i=0; i<N; i++){

            boolean swap = false;
            x++;
            for(int j=0; j<N-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            if(!swap)break;
        }
    
        return x;
     }
    
    public static void main(String... args){
        Scanner sc = new Scanner(System.in);
        int N,Q;
        N = sc.nextInt();
        Q = sc.nextInt();
        int Qarr[] = new int[Q];

        for(int i=0; i<Q; i++){
            Qarr[i] = sc.nextInt();
        }

        int marr[] = new int[N];
        
        int res[] = new int[Q];

        int temp[] = new int[N];

        for(int i=0; i<Q; i++){
            int index = Qarr[i]-1;
            marr[index] = 1;

            temp = marr.clone();
            res[i] = bubblesteps(temp, N);
            if(i<Q-1) System.out.print(res[i]+" ");
            else System.out.print(res[i]);
        }

    }
}
