import java.io.*;
import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String command = sc.hasNext() ? sc.next() : "";

        boolean[][] passVertical = new boolean[N][N];
        boolean[][] passHorizontal = new boolean[N][N];

        int curR = 0, curC = 0;
        for (int i = 0; i < command.length(); i++) {
            char cmd = command.charAt(i);
            // D, U, L, R로 움직일 경우 모서리 부분에 있으면 continue
            // 현재 자리와 움직인 자리 모두 체크
            if (cmd == 'D') {
                if (curR == N - 1) continue;;
                passVertical[curR][curC] = passVertical[curR + 1][curC] = true;
                curR++;
            }
            else if (cmd == 'U') {
                if (curR == 0) continue;
                passVertical[curR][curC] = passVertical[curR - 1][curC] = true;
                curR--;
            }
            else if (cmd == 'L') {
                if (curC == 0) continue;;
                passHorizontal[curR][curC] = passHorizontal[curR][curC - 1] = true;
                curC--;
            }
            else {
                if (curC == N - 1) continue;;
                passHorizontal[curR][curC] = passHorizontal[curR][curC + 1] = true;
                curC++;
            }
        }

        for (int i = 0; i < N; i++) {
            String ans = ""; // 한줄씩 출력
            for (int j = 0; j < N; j++) {
                if (passHorizontal[i][j] && passVertical[i][j]) ans += "+";
                else if (passVertical[i][j]) ans += "|";
                else if (passHorizontal[i][j]) ans += "-";
                else ans += ".";
            }
            System.out.println(ans);
        }
    }
}