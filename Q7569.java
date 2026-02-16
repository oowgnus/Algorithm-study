import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] index = new int[h][n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    index[k][i][j] = Integer.parseInt(st.nextToken());
                    if (index[k][i][j] == 1) {
                        queue.offer(new int[]{k, i, j});
                    }
                }
            }
        }

        int[] dk = {1, -1, 0, 0, 0, 0};
        int[] di = {0, 0, 1, -1, 0, 0};
        int[] dj = {0, 0, 0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int zk = curr[0];
            int zi = curr[1];
            int zj = curr[2];

            for (int i = 0; i < 6; i++) {
                int nk = zk + dk[i];
                int ni = zi + di[i];
                int nj = zj + dj[i];

                if (nk < 0 || nk >= h || ni < 0 || ni >= n || nj < 0 || nj >= m) continue;
                if (index[nk][ni][nj] == 0) {
                    index[nk][ni][nj] = index[zk][zi][zj] + 1;
                    queue.offer(new int[]{nk, ni, nj});
                }
            }
        }

        int max = 0;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (index[k][i][j] == 0) {
                        System.out.println("-1");
                        return;
                    }
                    max = Math.max(max, index[k][i][j]);
                }
            }
        }

        System.out.println(max - 1);
    }
}