import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        LinkedList<Character> list = new LinkedList<>();

        for(int i=0;i<line.length();i++){
            list.add(line.charAt(i));
        }

        int curr = line.length();
        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);

            if(a == 'L'){
                if(curr != 0) curr--;
            }else if(a == 'D'){
                if(curr != line.length()) curr++;
            }else if(a == 'B'){
                if(curr != 0){
                    list.remove(curr-1);
                }
            }else if(a == 'P'){
                char b = st.nextToken().charAt(0);
                list.add(curr, b);
                curr++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char text : list){
            sb.append(text);
        }

        System.out.println(sb);
    }
}
