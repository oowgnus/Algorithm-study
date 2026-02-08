import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] relation = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j) relation[i][j] = 0;
                else relation[i][j] = 999999;
            }
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation[a][b] = 1;
            relation[b][a] = 1;
        }

        int[] index = new int[n+1];
        Arrays.fill(index, 0);

        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(relation[i][j] > relation[i][k] + relation[k][j]){
                        relation[i][j] = relation[i][k] + relation[k][j];
                    }
                }
            }
        }

        for(int i=1;i<=n;i++){
            int sum = 0;
            for(int j=1;j<=n;j++){
                sum += relation[i][j];
            }
            index[i] = sum;
        }

        int min = Integer.MAX_VALUE;
        int result = 0;

        for(int i=1;i<=n;i++){
            if(min > index[i]){
                min = index[i];
                result = i;
            }
        }

        System.out.println(result);
    }
}
