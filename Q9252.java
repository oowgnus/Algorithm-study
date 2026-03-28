import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        char[] index = new char[line.length()+1];
        for(int i=1;i<=line.length();i++){
            index[i] = line.charAt(i-1);
        }
        
        String line2 = br.readLine();
        char[] index2 = new char[line2.length()+1];
        for(int i=1;i<=line2.length();i++){
            index2[i] = line2.charAt(i-1);
        }

        int[][] dp = new int[line.length()+1][line2.length()+1];
        Queue<Character> queue = new LinkedList<>();

        for(int i=1;i<=line.length();i++){
            for(int j=1;j<=line2.length();j++){
                if(index[i]==index2[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    queue.offer(index[i]);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int result = dp[line.length()][line2.length()];
        System.out.println(result);
    }
}
