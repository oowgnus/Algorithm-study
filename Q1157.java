import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Q1157 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String line = br.readLine();
    
    line = line.toLowerCase();

    int[] alphabet = new int[26];

    for(int i=0;i<line.length();i++){
      alphabet[line.charAt(i)-97]++;
    }

    int count = 0;
    int ind = -1;

    for(int i=0;i<26;i++){
      int n = alphabet[i];
      if(n>count){
        count = n;
        ind = i;
      }
    }

    for(int i=0;i<26;i++){
      if(alphabet[i] == count && i != ind){
        System.out.println("?");
        return;
      }
    }

    char c = (char)(ind+65);

    System.out.println(c);
  }
}