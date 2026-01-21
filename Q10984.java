import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10984 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            int a = 0;
            double gpa = 0;
            for(int j=0;j<N;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int b = Integer.parseInt(st.nextToken());
                double c = Double.parseDouble(st.nextToken());
                a += b;
                gpa += (c*b); 
            }
            double value = gpa/a;
            double result = Math.round(value*10) / 10.0;

            System.out.println(a+" "+result);
        }
    }
}
