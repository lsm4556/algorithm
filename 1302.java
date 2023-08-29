import java.io.*;
import java.util.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String title = sc.next();
            map.put(title, map.getOrDefault(title, 0) + 1);
//            if(map.containsKey(title))
//                map.put(title, map.get(title) + 1);
//            else map.put(title, 1);
        }

        String maxTitle = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> title : map.entrySet()) {
            String titleName = title.getKey();
            int count = title.getValue();
            if(count > maxCount ||
                    (count == maxCount && titleName.compareTo(maxTitle) < 0)) {
                maxTitle = titleName;
                maxCount = count;
            }
        }
        System.out.println(maxTitle);
    }
}