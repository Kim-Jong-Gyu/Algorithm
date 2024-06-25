import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


// 누적합

class Main {

    static ArrayList<Character> op = new ArrayList<>();
    static ArrayList<Integer> num = new ArrayList<>();

    static int ret = -987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        for(int i = 0; i < n; i++){
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
                op.add(input.charAt(i));
            }
            else {
                num.add(input.charAt(i) - '0');
            }
        }
        go(0, num.get(0));
        System.out.println(ret);
    }

    private static void go(int here, int result) {
        if(here == num.size() - 1){
            ret = Math.max(ret, result);
            return;
        }
        go(here + 1, calculate(result, num.get(here + 1), op.get(here)));

        if(here + 2 <= num.size() - 1){
            int tmp = calculate(num.get(here + 1), num.get(here + 2), op.get(here + 1));
            go(here + 2, calculate(result, tmp, op.get(here)));
        }
    }

    private static int calculate(int prev, int next, char op){
        if(op == '+')
            return prev + next;
        else if(op == '-')
            return prev - next;
        else
            return prev * next;
    }
}