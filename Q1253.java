import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1253 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] index = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0;i<n;i++){
      index[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(index);

    int count=0;

    for(int i=0;i<n;i++){
      int left = 0;
      int right = n-1;
      while (left<right) {
        int sum = index[left] + index[right];

        if(i==left){
          left++;
          continue;
        }else if(i==right){
          right--;
          continue;
        }

        if(index[i]==sum){
          count++;
          break;
        }else if(sum < index[i]){
          left++;
        }else{
          right--;
        }
      }
    }

    System.out.println(count);
  }
}
