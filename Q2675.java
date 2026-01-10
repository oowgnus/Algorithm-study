import java.io.*;
import java.util.*;

public class Q2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String text = st.nextToken();
            for(int j=0;j<text.length();j++){
                String line = Character.toString(text.charAt(j)).repeat(num);
                System.out.print(line);
            }
            System.out.println();

        }

        
    }
}
