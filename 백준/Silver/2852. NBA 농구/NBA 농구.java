import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static int at, bt, as, bs;
    static String prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String>[] li = new ArrayList[2];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String team = st.nextToken();
            String time = st.nextToken();
            if(as > bs){
                at = go(at, time);
            }
            if(as < bs){
                bt = go(bt, time);
            }
            if(team.equals("1")) as++;
            if(team.equals("2")) bs++;
            prev = time;
        }
        if(as > bs){
            at = go(at, "48:00");
        }
        if(as < bs) {
            bt = go(bt, "48:00");
        }
        printV(at);
        printV(bt);
    }

    private static int go(int sumT, String time) {
        return sumT + changeInt(time) - changeInt(prev);
    }

    private static int changeInt(String t){
        return Integer.parseInt(t.substring(0,2)) * 60 + Integer.parseInt(t.substring(3));
    }

    private static void printV(int result){
        String m = "00" + Integer.toString(result / 60);
        String s = "00" + Integer.toString(result % 60);
        System.out.println(m.substring(m.length() - 2) + ":" + s.substring(s.length() - 2));
    }

}