import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4714 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            double a = Double.parseDouble(br.readLine());
            if(a==-1.0) return;

            double b = a*0.167;

            System.out.print("Objects weighing ");
            System.out.printf("%.2f",a);
            System.out.print(" on Earth will weigh ");
            System.out.printf("%.2f",b);
            System.out.println(" on the moon.");
        }
    }
}
