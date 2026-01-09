import java.io.*;
import java.util.*;

public class Q2577 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());


        String line = Integer.toString(A*B*C);
        int [] index = new int [10];
        
        for(int i=0;i<10;i++){
            int count = 0;
            for(int j=0;j<line.length();j++){
                if(i == (line.charAt(j) - '0')){
                    count++;
                }
            }
            index[i] = count;
        }

        for(int i=0;i<10;i++){
            System.out.println(index[i]);
        }
    }
}
