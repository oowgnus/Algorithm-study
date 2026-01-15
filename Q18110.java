import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] index = new int[n];

        for(int i=0;i<n;i++){
            index[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(index);

        double people = n*0.15;
        if((people - (int)people) >= 0.5){
            people = (int)people + 1;
        }else{
            people = (int)people;
        }

        for(int i=0;i<people;i++){
            index[i] = 0;
        }
        for(int i=n-1;i>n-people-1;i--){
            index[i] = 0;
        }

        double result = 0;
        for(int i=0;i<n;i++){
            result += index[i];
        }

        result = result / (n-2*people);

        if((result - (int)result) >= 0.5){
            result = (int)result + 1;
        }else{
            result = (int)result;
        }
        
        System.out.println((int)result);
    }
}
