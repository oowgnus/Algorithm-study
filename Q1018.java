import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.classfile.BufWriter;
import java.util.StringTokenizer;

public class Q1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String[][] index = new String[N][M];

        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<M;j++){
                index[i][j] = Character.toString(line.charAt(j));
            }
        }
        
        int min = 64;

        for(int i=0;i<N-7;i++){
            for(int j=0;j<M-7;j++){
                int count = 0;
                for(int x=i;x<i+8;x++){
                    for(int y=j;y<j+8;y++){
                        if((x+y)%2 == 0){
                            if(index[x][y].equals("B")){
                                count++;
                            }
                        }else{
                            if(index[x][y].equals("W")){
                                count++;
                            }
                        }
                    }
                }
                count = Math.min(count, 64 - count);
                min = Math.min(min,count);
            }
        }

        System.out.println(min);

    }
}
