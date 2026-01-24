import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9469 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int P = Integer.parseInt(br.readLine());

        for(int i=0;i<P;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double num = Double.parseDouble(st.nextToken());
            double D = Double.parseDouble(st.nextToken());
            double A = Double.parseDouble(st.nextToken());
            double B = Double.parseDouble(st.nextToken());
            double F = Double.parseDouble(st.nextToken());
            
            double T = D/(A+B);
            double result = F*T;
            System.out.println(num+" "+result);
        }
    }
}
