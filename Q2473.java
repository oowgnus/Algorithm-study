import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2473 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] index = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0;i<n;i++){
      index[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(index);
    long result = Long.MAX_VALUE;

    int rl = 0;
    int rr = 0;
    int rm = 0;

    for(int i=0;i<n-2;i++){
      int left = i+1;
      int right = n-1;
      while (left<right) {
        long sum = (long)index[i] + index[left] + index[right];

        if(result>Math.abs(sum)){
          result = Math.abs(sum);
          rl = index[left];
          rr = index[right];
          rm = index[i];
        }

        if(sum<0){
          left++;
        }else if(sum>0){
          right--;
        }else if(sum==0){
          System.out.println(index[i]+" "+index[left]+" "+index[right]);
          return;
        }
      }
    }

    System.out.println(rm+" "+rl+" "+rr);
  }
}