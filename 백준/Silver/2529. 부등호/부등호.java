import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static boolean[] visited = new boolean[10];
    static String[] operate;
    static int n;
    static String max = "000000000";
    static String min = "999999999";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        operate = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < operate.length; i++) {
            operate[i] = st.nextToken();
        }
        for (int i = 0; i < 10; i++) {
            StringBuffer ret = new StringBuffer();
            visited[i] = true;
            go(i, 0, ret.append(i));
            visited[i] = false;
        }
        System.out.println(max);
        System.out.println(min);
    }

    private static void go(int here, int opIdx, StringBuffer ret) {
        if(opIdx == n){
            if(max.compareTo(ret.toString()) < 0){
                max = ret.toString();
            }
            if(min.compareTo(ret.toString()) > 0){
                min = ret.toString();
            }
            return;
        }
        for(int i = 0; i < 10; i++){
            if(visited[i])
                continue;
            if(here < i && operate[opIdx].equals("<")){
                ret.append(i);
                visited[i] = true;
                go(i, opIdx + 1, ret);
                ret.deleteCharAt(ret.length() - 1);
                visited[i] = false;
            }
            if(here > i && operate[opIdx].equals(">")){
                ret.append(i);
                visited[i] = true;
                go(i, opIdx + 1, ret);
                ret.deleteCharAt(ret.length() - 1);
                visited[i] = false;
            }
        }
    }
}