import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String line = br.readLine();

        int ans=0;
        int count=0;
        for(int i=1;i<m-1;i++){
            if(line.charAt(i-1)=='I' && line.charAt(i)=='O' && line.charAt(i+1)=='I'){
                ans++;

                if(ans>=n){
                    count++;
                }
                i++;
            }else{
                ans = 0;
            }
        }

        System.out.println(count);
    }
}
