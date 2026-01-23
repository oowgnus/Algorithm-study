import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1654 {
    public static int[] index;
    public static int n,k;

    public static void binarysearch(long low, long high){
        long ans=0;
        while(low<=high){
            long mid=(low+high)/2;
            long count=0;
            for(int i=0;i<n;i++){
                count+=index[i]/mid;
            }

            if(count<k){
                high = mid-1;
            }else{
                ans = mid;
                low = mid+1;
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        index = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            index[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,index[i]); 
        }

        binarysearch(1, max);
    }
}
