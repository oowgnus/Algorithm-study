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

    int avr = 0;

    int med;
    if(N == 1){
      med = index[0];
    }else{
      med = index[(int)(N/2)];
    }
    int range = index[N-1] - index[0];

    for(int i=0;i<N;i++){
      avr += index[i];
    }
    avr /= N;

    int [] count = new int[8001];
    int maxCount = 0;
    int mode = 0;
    for(int num : index){
      count[num+4000]++;
    }

    for(int i=0;i<count.length;i++){
      if(count[i]>maxCount){
        maxCount = count[i];
        mode = i;
      }
    }
    int most = index[count[mode]];
    if(mode == 1){
      most = index[1];
    }
  
    sb.append(avr+"\n");
    sb.append(med+"\n");
    sb.append(most+"\n");
    sb.append(range);

    System.out.println(sb);
  }
}
