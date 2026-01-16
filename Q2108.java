import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2108 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); 

    int [] index = new int[N];

    for(int i=0;i<N;i++){
      index[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(index);

    double average = 0;
    for(int i=0;i<N;i++){
      average += index[i];
    }
    average = Math.round(average/N);

    int median = index[(N+1)/2 -1];

    int mode = 0;
    int max = 0;
    int [] count = new int [8001];
    for(int i : index){
      count[i+4000]++;
      if(max < count[i+4000]){
        max = count[i+4000];
      }
    }

    boolean flag = false;
    for(int i=0;i<count.length;i++){
      if(count[i] == max){
        if(flag){
          mode = i -4000;
          break;
        }

        mode = i-4000;
        flag = true;
      }
    }


    int range = index[N-1] - index[0];

    sb.append((int)average+"\n"+median+"\n"+mode+"\n"+range);
    System.out.println(sb);
  }
}
