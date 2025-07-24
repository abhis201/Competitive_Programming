import java.util.ArrayList;
import java.util.Scanner;

public class smallestarray {
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        ArrayList<Integer> small = new ArrayList<Integer>();

        int left = x;
        int max = 10000;
        while(left!=0){
            if(left>10000){
                left = left - max;
                small.add(max--);
            }
            else{
                small.add(left);
                left = 0;
            }
        }

        for(int i=small.size()-1; i>0; i--){
            System.out.print(small.get(i)+" ");
        }
        System.out.println(small.get(0));
        
    }
}
