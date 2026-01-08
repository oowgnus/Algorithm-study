import java.io.*;
import java.util.StringTokenizer;

public class Q10250 {

    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());

        String [] result = new String[n];


        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int j = N/H;
            if(N > H){
                N = N - j*H;
            }

            result[i] = Integer.toString(N) + "0" + Integer.toString(j+1);
        }

        for(int i = 0; i < n; i++){
            System.out.println(result[i]);
        }
    }
}