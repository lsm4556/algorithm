import java.io.*;
import java.util.*;

class Main
{
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // 1. 입력된 좌표를 작은 순으로 정렬한다.
//        int[][] xs = new int[N][2]; // 0: x, 1: inputIndex
//
//        for(int i=0; i<N; i++) {
//            xs[i][0] = sc.nextInt();
//            xs[i][1] = i;
//        }
//
//        Arrays.sort(xs, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
        int[] xs = new int[N];
        Set<Integer> set = new TreeSet<>();
        for(int i = 0; i < N; i++) {
            xs[i] = sc.nextInt();
            set.add(xs[i]);
        }


        // 2. 정렬된 좌표를 중복을 제거하며 압축된 인덱스를 기록한다.
//        int[] ans = new int[N];
//        int idx = 0;
//        ans[xs[0][1]] = idx;
//        for (int i = 1; i < N; i++) {
//            if (xs[i][0] != xs[i - 1][0]) idx++;
//            ans[xs[i][1]] = idx;
//        }
        Map<Integer, Integer> sortedIndex = new HashMap<>();
        int idx = 0;
        for (int x : set)
            sortedIndex.put(x, idx++);

        // 3. 입력된 좌표에 알맞은 압축 인덱스를 출력한다.
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        for (int i = 0; i < N; i++)
//            bw.write(ans[i] + " ");
//        bw.write("\n");
//        bw.flush();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++)
            bw.write(sortedIndex.get(xs[i]) + " ");
        bw.write("\n");
        bw.flush();
    }
}