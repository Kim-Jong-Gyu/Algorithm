import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    // 짝 짓기 문제 -> Stack으로 한번 생각해보자
    // 사고의 흐름 : 오큰수가 아닐 때, 담아놓는다.
    static int[] inputs;
    static int[] outputs;
    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        inputs = new int[n];
        outputs = new int[n];

        for(int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(st.nextToken());
            while(s.size() != 0 && inputs[s.peek()] < inputs[i]){
                outputs[s.pop()] = inputs[i];
            }
            s.push(i);
        }
        while (!s.empty()){
            outputs[s.pop()] = -1;
        }

        for(int i = 0; i < n; i++)
            sb.append(outputs[i]).append(" ");
        
        System.out.println(sb);
    }
}