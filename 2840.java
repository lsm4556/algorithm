import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        char[] arr = new char[N];
        Arrays.fill(arr, '?'); // 배열 ?로 채우기

        int cur = 0;
        boolean correct = true;

        for (int i=0; i<K; i++) {
            int movNum = sc.nextInt();
            char a = sc.next().charAt(0); // char 하나씩 받기
            cur = (cur + movNum) % N; // 배열 받기

            if(arr[cur] != '?' && arr[cur] != a) {
                correct = false;
                break;
            }
            else {
                arr[cur] = a;
            }
        }

        if(correct) {
            for (int i=0; i<N; i++) {
                System.out.print(arr[cur]); // 배열 거꾸로 출력
                cur = ((cur - 1)%N + N) % N;
            }
        }
        else {
            System.out.println('!');
        }
    }
}