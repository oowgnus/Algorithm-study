import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] index = new int[n][3];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                index[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] maxdp = new int[n][3];
        int[][] mindp = new int[n][3];

        maxdp[0][0] = index[0][0];
        maxdp[0][1] = index[0][1];
        maxdp[0][2] = index[0][2];

        mindp[0][0] = index[0][0];
        mindp[0][1] = index[0][1];
        mindp[0][2] = index[0][2];

        for(int i=1;i<n;i++){
            maxdp[i][0] = Math.max(maxdp[i-1][0],maxdp[i-1][1]) + index[i][0];
            maxdp[i][2] = Math.max(maxdp[i-1][2],maxdp[i-1][1]) + index[i][2];
            int max = Math.max(maxdp[i-1][0],maxdp[i-1][1]);
            max = Math.max(max,maxdp[i-1][2]);
            maxdp[i][1] = max + index[i][1];
            
            mindp[i][0] = Math.min(mindp[i-1][0],mindp[i-1][1]) + index[i][0];
            mindp[i][2] = Math.min(mindp[i-1][2],mindp[i-1][1]) + index[i][2];
            int min = Math.min(mindp[i-1][0],mindp[i-1][1]);
            min = Math.min(min,mindp[i-1][2]);
            mindp[i][1] = min + index[i][1];
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<3;i++){
            max = Math.max(maxdp[n-1][i],max);
            min = Math.min(mindp[n-1][i],min);
        }

        System.out.println(max+" "+min);
    }
}
