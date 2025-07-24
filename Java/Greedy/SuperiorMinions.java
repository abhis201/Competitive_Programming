import java.util.Scanner;

class SuperiorMinions{

    public static int solve(String test){

        int length = test.length()+1;

        int candies[] = new int[length];
        candies[0] = 1;

        for(int i=1; i<length; i++){
            if(test.charAt(i-1)=='<'){
                candies[i] = candies[i-1]+1;
            }
            else if(test.charAt(i-1)=='>'){
                candies[i] = candies[i-1]-1;
                int j = i;
                int add = 0;
                if(candies[i]==0){
                    j = i;
                    candies[i] = 1;
                    while(j-1>=0 && candies[j-1]==candies[j]){
                        candies[j-1] += 1;
                        j--;
                    }
                }
            }
        }
        int sum = 0;
        for(int i=0; i<length; i++){
            sum += candies[i];
        }

        return sum;
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

            String test = sc.next();
            System.out.println(solve(test));
            // solve(test);
        
    }
 }