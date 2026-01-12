import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] index = new String[3];

        for(int i=0;i<3;i++){
            index[i] = br.readLine();
        }
        int count = 0;

        for(int i=0;i<3;i++){
            try{
                int num = Integer.parseInt(index[i]);
                count =  Integer.parseInt(index[i]) + (3-i);
                if(count%3 == 0 && count%5==0){
                System.out.println("FizzBuzz");
                }else if (count%3 == 0 && count%5!=0){
                System.out.println("Fizz");
                }else if(count%3 != 0 && count%5==0){
                System.out.println("Buzz");
                }else{
                System.out.println(count);
                }
            }catch(NumberFormatException e){
                continue;
            }
            
        }   
    }
}
