import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q25704 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        int min = P;
        if(N>=5) min = Math.min(min, P-500);
        if(N>=10) min = Math.min((int)(P*0.9), min);
        if(N>=15) min = Math.min(P-2000, min);
        if(N>=20) min = Math.min((int)(P*0.75), min);

        if(min<0) min=0;

        System.out.println(min);
    }
}
