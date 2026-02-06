import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] index = new int[n][m];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                index[i][j] = Integer.parseInt(st.nextToken());

                max = Math.max(index[i][j],max);
                min = Math.min(min, index[i][j]);
            }
        }

        int timemin = Integer.MAX_VALUE;
        int ansHeight = -1;


        for(int i=min;i<=max;i++){
            int seconds = 0;
            int inventory = b;

            for(int j=0;j<n;j++){
                for(int h=0;h<m;h++){
                    int diff = index[j][h] - i;

                    if(diff>0){
                        seconds += (diff*2);
                        inventory += diff;
                    }else if(diff<0){
                        seconds += (Math.abs(diff)*1);
                        inventory -= Math.abs(diff);
                    }
                }
            }

            if(inventory>=0){
                if(seconds<=timemin){
                    timemin = seconds;
                    ansHeight = i;
                }
            }
        }

        System.out.println(timemin+" "+ansHeight);
    }
}
