import java.io.*;
import java.util.StringTokenizer;

public class Q10250 {

    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int floor;
            int room;

            if(N%H == 0){
                floor = H;
                room = N/H;
            }else{
                floor = N%H;
                room = N/H + 1;
            }
            System.out.println(floor*100 + room);
        }
    }
}