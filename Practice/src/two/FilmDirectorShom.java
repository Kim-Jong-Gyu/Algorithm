package two;

import java.util.Scanner;

public class FilmDirectorShom {

    static void main() {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int number = 0;
        while (n != 0) {
            number++;
            String str = Integer.toString(number);
            if (str.contains("666")) {
                n--;
            }
        }
        System.out.println(number);
    }

}
