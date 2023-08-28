import java.io.*;
import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[][] records = new String[N][2];
        for (int i = 0; i < N; i++) {
            records[i][0] = sc.next();
            records[i][1] = sc.next();
        }
        // 1. 이름 순서에 따라 출입기록을 차례로 정렬한다.
        Arrays.sort(records, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o2[0].compareTo(o1[0]);
            }
        });

        // 2. 각 사원마다 마지막 기록이 enter라면, 출력한다. (사전 역순)
        for (int i = 0; i < N - 1; i++)
            if (!records[i][0].equals(records[i + 1][0]) && records[i][1].equals("enter"))
                System.out.println(records[i][0]);
        if (records[N - 1][1].equals("enter"))
            System.out.println(records[N - 1][0]);


//        Set<String> entered = new TreeSet<>();
//
//        for (int i=0; i<N; i++) {
//            String name = sc.next();
//            String status = sc.next();
//
//            if(status.equals("enter")) {
//                entered.add(name);
//            }
//            else {
//                entered.remove(name);
//            }
//        }
//
//        String[] orderedAnswer = entered.toArray(new String[entered.size()]);
//        for (int i=orderedAnswer.length-1; i>=0; i--)
//            System.out.println(orderedAnswer[i]);
    }
}