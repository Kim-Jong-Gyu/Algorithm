import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int n = 0;
    static char[][] mp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        mp = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                mp[i][j] = s.charAt(j);
            }
        }
        String answer = "";
        System.out.println(quad(0,0, n));

    }

    private static String quad(int y, int x, int rng) {
        if(rng == 1) return String.valueOf(mp[y][x]);
        char check = mp[y][x];
        String ret = "";
        for(int i = y; i < y + rng; i++){
            for(int j = x; j < x + rng; j++){
                if(mp[i][j] != check){
                    ret += "(";
                    ret += quad(y, x, rng/2);
                    ret += quad(y, x + rng/2, rng/2);
                    ret += quad(y + rng/2, x, rng/2);
                    ret += quad(y + rng/2, x + rng/2, rng/2);
                    ret += ")";
                    return ret;
                }
            }
        }
        return String.valueOf(mp[y][x]);
    }
}