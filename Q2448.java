import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2448 {
    public static char[][] index;
    public static int n;

    public static void star(int h,int r, int c){
        if(h==3){
            index[r][c] = '*';
            index[r+1][c-1] = '*';
            index[r+1][c+1] = '*';
            for(int i=-2;i<=2;i++){
                index[r+2][c+i] = '*';
            }
            return;
        }

        star(h/2,r,c);
        star(h/2,r+h/2,c-h/2);
        star(h/2,r+h/2,c+h/2);
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        index = new char[n][2*n-1];
        for(int i=0;i<n;i++){
            Arrays.fill(index[i], ' ');
        }

        star(n,0,n-1);

        for(int i=0;i<n;i++){
            for(int j=0;j<2*n-1;j++){
                sb.append(index[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}