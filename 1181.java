import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] words = new String[N];
        for (int i = 0; i < N; i++)
            words[i] = sc.next();

        // 1. 길이가 짧은 것부터
        // 2. 길이가 같으면 사전 순으로
        Arrays.sort(words, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                return o2.length() - o1.length();
            }
        });

        System.out.println(words[0]);
        for (int i=1; i<N; i++)
            if(!words[i].equals(words[i-1]))
                System.out.println(words[i]);
    }
}