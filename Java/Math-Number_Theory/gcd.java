import java.util.Scanner;

public class gcd {

    int gcd(int a, int b){

        while(b!=0){
            int div = a%b;
            a = b;
            b = div;
        }

        return b;
    }

    public static void solve(int size, int sum){

        int X = size;
        int Y = sum;

        int arr[] = new int[size];

        int add = 0;

        for(int i=0; i<size; i++){
            add = X/Y;
            arr[i] = add;
            X--;
            Y = Y-add;
        }
    }
    
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-->0){
            int size = sc.nextInt();
            int sum = sc.nextInt();


        }
    }
}
