import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14500 {
    public static int[][] index;
    public static boolean[][] visited;
    public static int n,m;

    public static void bfs(int r, int c){
        for(int i=0;i<n;i++){
            
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        index = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                index[i][j] = Integer.parseInt(st.nextToken());
            }
        }

                                                                                                                                                                                                                                                                              
    }
}
