import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q30676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ramda = Integer.parseInt(br.readLine());

        if(ramda>=620 && ramda<=780){
            System.out.println("Red");
        }else if(ramda>=590 && ramda<620){
            System.out.println("Orange");
        }else if(ramda>=570 && ramda<590){
            System.out.println("Yellow");
        }else if(ramda>=495 && ramda<570){
            System.out.println("Green");
        }else if(ramda>=450 && ramda<495){
            System.out.println("Blue");
        }else if(ramda>=425 && ramda<450){
            System.out.println("Indigo");
        }else if(ramda>=380 && ramda<425){
            System.out.println("Violet");
        }
    }
}
