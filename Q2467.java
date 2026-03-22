import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2467 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] index = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0;i<n;i++){
      index[i] = Integer.parseInt(st.nextToken());
    }

    int left = 0;
    int right = n-1;
    
    int sum = 0;
    int result = Integer.MAX_VALUE;
    int rl = 0;
    int rr = 0;

    while(left < right){
      sum = index[left] + index[right];
      
      if(result>Math.abs(sum)){
        result = Math.abs(sum);
        rl = index[left];
        rr = index[right];
      }

      if(sum<0){
        left++;
      }else if(sum>0){
        right--;
      }else if(sum==0){
        System.out.println(index[left]+" "+index[right]);
        return;
      }

    }

    System.out.println(rl+" "+rr);
  }
}
