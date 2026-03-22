import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Q1316 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int count=0;
    for(int i=0;i<n;i++){
      HashMap<Character, Integer> map = new HashMap<>();
      String line = br.readLine();
      boolean flag = false;
      map.put(line.charAt(0),1);
      for(int j=1;j<line.length();j++){
        char a = line.charAt(j);

        if(!map.containsKey(a)){
          map.put(a,1);
        }else if(map.containsKey(a) && a==line.charAt(j-1)){
          continue;
        }else{
          flag = true;
        }
      }
      if(!flag){
        count++;
      }
    }

    System.out.println(count);
  }
}
