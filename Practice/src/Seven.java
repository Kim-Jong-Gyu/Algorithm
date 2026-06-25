import java.util.*;

/**
 * 일곱 난쟁이
 *
 */
class Seven {

    static List<Integer> result = new ArrayList<>();

    static void main() {
        Scanner sc = new Scanner(System.in);

        // 1. Input
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            int num = sc.nextInt();
            li.add(num);
        }

        // 3. 순열
        permutation(li, 9, 7, 0);
        for (int i = 0; i < 7; i++) {
            System.out.println(result.get(i));
        }

        System.exit(0);
    }

    static void solve(List<Integer> li, int r) {
        int sum = 0;
        for(int i = 0; i < r; i++) {
            sum += li.get(i);
        }
        if(sum == 100) {
            Collections.sort(li.subList(0, 7));
            result.addAll(li);
        }
    }

    static void permutation(List<Integer> li, int n, int r, int depth ) {
        if(depth == r) {
            solve(li, r);
        }
        for(int i = depth; i < n; i++) {
            Collections.swap(li, i, depth);
            permutation(li, n, r, depth + 1);
            Collections.swap(li, i, depth);
        }
    }
}

