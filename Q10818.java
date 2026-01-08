import java.io.*;
import java.util.StringTokenizer;

public class Q10818 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int [] index = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N;i++){
            index[i] = Integer.parseInt(st.nextToken());
        }

        int max = index[0];
        int min = index[0];

        for(int i=1;i<N; i++){
            if(index[i] >= max){
                max = index[i];
            }else if(index[i] < min){
                min = index[i];
            }
        }
        System.out.println(min +" "+ max);
    }
}
