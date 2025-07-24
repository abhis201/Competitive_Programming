import java.util.Scanner;

public class EqualizeArray {

    public static boolean isDivisible(int a,int index, int arr5[], int arr13[], int arr19[]){

        if(a%19==0){
            arr13[index] = a/19;
        }
        else if(a%13==0){
            arr13[index] = a/13;
        }
        else if(a%5==0){
            arr5[index] = a/5;
        }
        else if((a%19)==7){
            arr19[index] = a/19-1;
            arr13[index] = 2;
        }
        else if((a%19)%13==0){
            arr19[index] = a/19;
            arr13[index] = (a%19)/13;
        }
        else if((a%19)==1){
            arr19[index] = a/19-1;
            arr5[index] = 4;
        }
        else if((a%19)==6){
            arr19[index] = a/19-1;
            arr5[index] = 5;
        }
        else if((a%19)==11){
            arr19[index] = a/19-1;
            arr5[index] = 6;
        }
        else if((a%19)==16){
            arr19[index] = a/19-1;
            arr5[index] = 7;
        }
        else if((a%19)%5==0){
            arr19[index] = a/19;
            arr5[index] = (a%19)/5;
        }
        else if((a%13)==2){
            arr13[index] = a/13-1;
            arr5[index] = 3;
        }
        else if((a%13)==7){
            arr13[index] = a/13-1;
            arr5[index] = 4;
        }
        else if((a%13)==12){
            arr13[index] = a/13-1;
            arr5[index] = 5;
        }
        else if((a%13)%5==0){
            arr13[index] = a/13;
            arr5[index] = (a%13)/5;
        }
        else if(((a%19)%13)%5==0){
            arr19[index] = a/19;
            arr13[index] = (a%19)/13;
            arr5[index] = ((a%19)%13)/5;
        }
        else{
            return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-->0){
            int N = sc.nextInt();

            int marr[] = new int[N];

            int arr5[] = new int[N];
            int arr13[] = new int[N];
            int arr19[] = new int[N];

            // System.out.println(isDivisible(47, 0, arr5, arr13, arr19));
            int total = 0;

            boolean div = true;
            for(int i = 0; i<N; i++){
                marr[i] = sc.nextInt();
                if(isDivisible(marr[i],i,arr5,arr13,arr19)==false){
                    div = false;
                    break;
                }
            }

            if(!div){
                System.out.println("-1");
                continue;
            }

            boolean goahead = false;

            while(!goahead){

                boolean flag = false;
                int steps = 0;
                for(int i=0; i<N; i++){
                    if(arr5[i]==0 && flag==true){
                        flag = false;
                        total++;
                    }
                    else if(arr5[i]>0)
                    {
                        arr5[i] = arr5[i] - 5;
                        flag = true;
                    }
                    else{
                        steps++;
                        if(steps==N){
                            goahead = true;
                            break;
                        }
                    }
                }
            }

            goahead = false;

            while(!goahead){

                boolean flag = false;
                int steps = 0;
                for(int i=0; i<N; i++){
                    if(arr13[i]==0 && flag==true){
                        flag = false;
                        total++;
                    }
                    else if(arr13[i]>0)
                    {
                        arr13[i] = arr13[i] - 13;
                        flag = true;
                    }
                    else{
                        steps++;
                        if(steps==N){
                            goahead = true;
                            break;
                        }
                    }
                }
            }

            goahead = false;

            while(!goahead){

                boolean flag = false;
                int steps = 0;
                for(int i=0; i<N; i++){
                    if(arr19[i]==0 && flag==true){
                        flag = false;
                        total++;
                    }
                    else if(arr19[i]>0)
                    {
                        arr19[i] = arr19[i] - 19;
                        flag = true;
                    }
                    else{
                        steps++;
                        if(steps==N){
                            goahead = true;
                            break;
                        }
                    }
                }
            }
            
                System.out.println(total);
            
        }
    }
}
