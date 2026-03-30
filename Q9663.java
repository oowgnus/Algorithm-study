import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9663 {
    public static int n;
    public static int[] row;
    public static int count=0;

    public static boolean isPossibe(int col){
        for(int i=0;i<col;i++){
            if(row[col]==row[i]){
                return false;
            }else if(Math.abs(row[col]-row[i])==Math.abs(col-i)){
                return false;
            }
        }
        return true;
    }

    public static void nQueen(int depth){
        if(depth==n){
            count++;
            return;
        }

        for(int i=0;i<n;i++){
            row[depth] = i;

            if(isPossibe(depth)){
                nQueen(depth+1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        row = new int[n];

        nQueen(0);
        System.out.println(count);
    }
}