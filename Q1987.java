import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1987 {
    public static int r,c;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static boolean[] alphabet = new boolean[26];
    public static int maxsize=0;
    public static char[][] index;

    public static void dfs(int x, int y, int count){

        maxsize = Math.max(maxsize, count);

        for(int i=0;i<4;i++){
            int rx = x + dx[i];
            int ry = y + dy[i];

            if(rx<=0 || rx>r || ry<=0 || ry>c) continue;

            int alphindex = index[rx][ry] -'A';
            
            if(!alphabet[alphindex]){
                alphabet[alphindex] = true;

                dfs(rx,ry,count+1);

                alphabet[alphindex] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        index = new char[r+1][c+1];

        for(int i=1;i<=r;i++){
            String line = br.readLine();
            for(int j=1;j<=c;j++){
                index[i][j] = line.charAt(j-1);
            }
        }

        int firstalp = index[1][1]-'A';
        alphabet[firstalp] = true;

        dfs(1, 1, 1);

        System.out.println(maxsize);
    }  
}
