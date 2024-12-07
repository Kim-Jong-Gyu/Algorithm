import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {


    static class Node {
        long num;
        // case : 같은게 왔을 때는, 누적합이 필요하다.
        long cnt;

        public Node(long num, long cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        Stack<Node> stk = new Stack<>();
        long ret = 0;
        for(int i = 0; i < n; i++){
            long cur = Long.parseLong(br.readLine());
            long cnt = 1;
            // case : 오름차순, 같은 경우
            while (!stk.isEmpty() && stk.peek().num <= cur){
                ret += stk.peek().cnt;
                if(stk.peek().num == cur)
                    cnt = stk.peek().cnt + 1;
                else
                    cnt = 1;
                stk.pop();
            }
            // case : 내림차순
            if(!stk.isEmpty())
                ret++;
            stk.push(new Node(cur, cnt));
        }
        System.out.println(ret);
    }
}