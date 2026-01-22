import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.MAX_VALUE;

        String[] minusSplit = br.readLine().split("-");

        for(String temp : minusSplit){
            int sum=0;

            String[] plusSplit = temp.split("\\+");
            for(String num : plusSplit){
                sum += Integer.parseInt(num);
            }

            if(total == Integer.MAX_VALUE){
                total = sum;
            }else{
                total -= sum;
            }
        }

        System.out.println(total);
    }
}