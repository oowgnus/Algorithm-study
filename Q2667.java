import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int [][] index = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<n;j++){
                index[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
            }
        }

        ArrayList<Integer> array = new ArrayList<>();

        int[] dx = {0,0,1,-1};
        int[] dy = {-1,1,0,0};

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int count = 0;
                if(index[i][j]==1 && !visited[i][j]){
                    visited[i][j] = true;
                    queue.offer(new int[]{i,j});

                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int r = curr[0];
                        int c = curr[1];

                        for(int k=0;k<4;k++){
                            int nr = r + dx[k];
                            int nc = c + dy[k];

                            if(nr>=n || nr<0 || nc>=n || nc<0) continue;

                            if(index[nr][nc] == 1 && !visited[nr][nc]){
                                visited[nr][nc] = true;
                                queue.offer(new int[]{nr,nc});
                            }
                        }
                        count++;
                    }

                    array.add(count);
                }
            }
        }

        Collections.sort(array);

        System.out.println(array.size());
        for(int i=0;i<array.size();i++){
            System.out.println(array.get(i));
        }
    }
}
