import java.util.Scanner;
import java.util.*;

public class Main {

    public static int n;

    public static List<Integer> inputList = new ArrayList<>();

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long sum = 0;

        for(int i = 0; i < n; i++) {
            int input = sc.nextInt();
            sum += input;
            inputList.add(input);
        }

        // 1. 정렬
        Collections.sort(inputList);

        // 2. 산술평균
        System.out.println(Math.round(sum/(double)n));

        // 3. 중간값
        System.out.println(inputList.get((n-1)/2));

        // 4. 최빈값
        Map<Integer, Integer> map = new TreeMap<>();
        for (int x : inputList) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int maxCount = 0;
        for (int cnt : map.values()) {
            if (cnt > maxCount) maxCount = cnt;
        }

        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() == maxCount) {
                modes.add(e.getKey());
            }
        }

        int answer = (modes.size() >= 2) ? modes.get(1) : modes.get(0);
        System.out.println(answer);

        // 5. 범위
        System.out.println(inputList.get(n-1) - inputList.get(0));
    }

}