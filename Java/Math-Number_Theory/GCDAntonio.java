import java.util.Scanner;

public class GCDAntonio {
    
    public static int GCD(int x, int y){
        if(x<y) return GCD(y,x);
        while(y!=0){
            int rem = x%y;
            x = y;
            y = rem;
        }
        
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T--!=0){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();

            boolean found = false;

            int start = 0;
            if(C<A) start = A;
            else start = C;        
            for(int i = start; i<=B; i++){
                if(i%C!=0) continue;
                for(int j = C+i; j<=B; j++){
                    if(j%C!=0) continue;
                    
                    if(GCD(j,i)==C)
                    {
                        System.out.println("YES");
                        found = true;
                        break;
                    }
                }
                if(found) break;
            }

            if(!found) System.out.println("NO");
        }
    }
}
