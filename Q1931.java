import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] index = new int[n][2];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            index[i][0] = Integer.parseInt(st.nextToken());
            index[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(index,(o1,o2) ->{
            if(o1[1]==o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int count = 1;
        int finish = index[0][1];

        for(int i=1;i<n;i++){
            if(index[i][0] < finish) continue;
            else{
                count++;
                finish = index[i][1];
            }
        }
        System.out.println(count);
    }
}
