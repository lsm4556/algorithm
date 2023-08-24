import java.io.*;
import java.util.Scanner;

class Main {
    public static void main (String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 테스트 케이스만큼 반복문
        while(n-- > 0) {
            int H = sc.nextInt(); // 엘리베이터 층수
            int W = sc.nextInt(); // 엘리베이터 방수
            int C = sc.nextInt(); // 몇번째 고객

            int x = 1; // 몇층인지

            x = x + C / H; // 몇호인지
            C = C % H; // 몇층인지

            System.out.printf("%d%02d\n", C, x); // 호수는 01, 02, ...으로 표시될 수 있게 %02d
        }

    }
}