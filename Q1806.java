import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1806 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());

    int[] index = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i=0;i<n;i++){
      index[i] = Integer.parseInt(st.nextToken());
    }

    int left = 0;
    int right = 0;
    int min = Integer.MAX_VALUE;
    int sum = 0;

    while (true) {
      if (sum >= s) {
        min = Math.min(min, right - left);
        sum -= index[left++];
      } else if (right == n) {
          break;
      } else {
          sum += index[right++];
      }
    }

    if (min == Integer.MAX_VALUE) {
      System.out.println(0);
    } else {
      System.out.println(min);
    }
  }
}
