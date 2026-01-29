import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] fruit = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            fruit[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int max = 0;
        int type = 0;
        int[] count = new int[10];

        for(right=0;right<N;right++){
            int rightfruit = fruit[right];

            if(count[rightfruit] == 0){
                type++;
            }
            count[rightfruit]++;

            while(type>2){
                int leftfruit = fruit[left];
                count[leftfruit]--;

                if(count[leftfruit] == 0){
                    type--;
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        System.out.println(max);
    }
}
