import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static int n, m;
    static ArrayList<Node> houseArr;
    static ArrayList<Node> chickenArr;
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        houseArr = new ArrayList<>();
        chickenArr = new ArrayList<>();
        int input;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                input = Integer.parseInt(st.nextToken());
                if(input == 1)
                    houseArr.add(new Node(i,j));
                if(input == 2)
                    chickenArr.add(new Node(i,j));
            }
        }
        ArrayList<Node> arr = new ArrayList<>();
        for(int i = 1; i <= m; i++){
            combination(-1, arr);
        }
        System.out.println(ret);
    }

    private static void combination(int start ,ArrayList<Node> arr) {
        if(arr.size() == m){
            ret = Math.min(ret, check(arr));
            return;
        }
        for(int i = start + 1; i < chickenArr.size(); i++){
            arr.add(chickenArr.get(i));
            combination(i, arr);
            arr.remove(arr.size() - 1);
        }
    }

    private static int check(ArrayList<Node> arr) {
        int chk = 0;
        for(int i = 0; i < houseArr.size(); i++){
            int minDis = Integer.MAX_VALUE;
            for(int j = 0; j < arr.size(); j++){
                int abs1 = Math.abs(houseArr.get(i).getX() - arr.get(j).getX());
                int abs2 = Math.abs(houseArr.get(i).getY() - arr.get(j).getY());
                int dis = abs1 + abs2;
                minDis = Math.min(minDis, dis);
            }
            chk += minDis;
        }
        return chk;
    }
}

class Node {
    private int y;
    private int x;
    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
    public int getY(){
        return this.y;
    }
    public int getX(){
        return this.x;
    }
}