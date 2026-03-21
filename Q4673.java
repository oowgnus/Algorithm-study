import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4673 {
    public static boolean[] number;

    public static int d(int n){
        int sum = n;
        while(n>0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = new boolean[10001];

        for(int i=1;i<=10000;i++){
            int dn = d(i);
            if(dn<=10000){
                number[dn] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=10000;i++){
            if(!number[i]){
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
