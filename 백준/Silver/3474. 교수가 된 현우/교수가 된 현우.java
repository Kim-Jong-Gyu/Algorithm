import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        ArrayList<Integer> li = new ArrayList<>();
        ArrayList<Integer> outputs = new ArrayList<>();
        for(int i = 0; i < t; i++){
            int input = Integer.parseInt(br.readLine());
            li.add(input);
        }
        for(int el : li){
            int ret2 = 0;
            int ret5 = 0;
            for(int j = 2; j <= el; j *= 2){
                ret2 += el/j;
            }
            for(int j = 5; j <= el; j *= 5){
                ret5 += el/j;
            }
            outputs.add(Math.min(ret2, ret5));
        }
        for(int el : outputs){
            System.out.println(el);
        }
    }
}