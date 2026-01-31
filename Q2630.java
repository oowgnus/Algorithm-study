import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2630 {
    public static int n;
    public static int[][] index;
    public static int white=0;
    public static int blue=0;

    public static boolean isSameColor(int r,int c,int size){
        int first = index[r][c];
        for(int i=r;i<r+size;i++){
            for(int j=c;j<c+size;j++){
                if(index[i][j] != first){
                    return false;
                }
            }
        }
        return true;
    }

    public static void check(int r, int c, int size){
        if(isSameColor(r, c, size)){
            if(index[r][c]==0) white++;
            else blue++; 
        }else{
            int half = size/2;
            check(r, c, half);
            check(r, c + half, half);
            check(r +half, c, half);
            check(r +half, c +half, half);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        index = new int[n+1][n+1];

        for(int i=1;i<n+1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<n+1;j++){
                index[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check(1,1,n);
        System.out.println(white);
        System.out.println(blue);
    }
}
