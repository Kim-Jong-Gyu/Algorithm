import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int tmp = 0;
        if (arr[0] == arr[1] && arr[1] == arr[2]) {
            System.out.println(10000 + arr[0] * 1000);
        }
        else if(arr[0] != arr[1] && arr[1] != arr[2] && arr[0] != arr[2]){
            int max = arr[0] > arr[1] && arr[0] > arr[2] ? arr[0] : Math.max(arr[1], arr[2]);
            System.out.println(max * 100);
        }
        else {
            int num = arr[0] == arr[1] ? arr[0] : arr[1] == arr[2] ? arr[1] : arr[2];
            System.out.println(1000 + 100 * num);
        }
    }
}