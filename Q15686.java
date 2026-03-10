import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q15686 {
    public static int n,m;
    public static boolean[] visited; 
    public static ArrayList<Point> chicken;
    public static ArrayList<Point> house;
    public static int ans = Integer.MAX_VALUE;

    static class Point{
        int x,y;

        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void dfs(int start, int count){
        if(count == m){
            int sum = 0;
            for(Point p : house){
                int mindist = Integer.MAX_VALUE;
                for(int i=0;i<chicken.size();i++){
                    if(visited[i]){
                        int abs = Math.abs(p.x - chicken.get(i).x) + Math.abs(p.y - chicken.get(i).y);
                        mindist = Math.min(mindist, abs);
                    }
                }
                sum += mindist;
            }
            ans = Math.min(ans, sum);
            return;
        }

        for(int i=start;i<chicken.size();i++){
            if(visited[i]) continue;

            visited[i] = true;
            dfs(i+1,count+1);
            visited[i] = false;
        }
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    house.add(new Point(i, j));
                }else if(num == 2){
                    chicken.add(new Point(i, j));
                }
            }
        }

        visited = new boolean[chicken.size()];

        dfs(0,0);

        System.out.println(ans);

    }
}