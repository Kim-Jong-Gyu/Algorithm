import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static HashMap<Integer, Integer> mp = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> original = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(st.nextToken()));
            original.add(list.get(i));
            mp.put(list.get(i), mp.getOrDefault(list.get(i), 0) + 1);
        }
        Collections.sort(list, (o1, o2) -> {
            if(mp.get(o1) == mp.get(o2)){
                return original.indexOf(o1) - original.indexOf(o2);
            }
            else {
                return Integer.compare(mp.get(o2), mp.get(o1));
            }
        });
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }
}