package LV2;

import java.util.ArrayList;
import java.util.List;

public class N진수게임 {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int cnt = 0;
        int number = 0; // 말해야하는 숫자
        int k = m * (t-1) + p;   // 미리 구해놔야 하는 순서
        List<Character> list = new ArrayList<>();
        while (cnt < k) {
            String x = Integer.toString(number, n);
            x = x.toUpperCase();
            for (char c : x.toCharArray()) {
                list.add(c);
                cnt ++;
            }
            number ++;
        }
        for (int i=0; i<list.size(); i++) {
            if (answer.length() == t) break;
            if (i%m == p-1) {
                answer += list.get(i);
            }
        }

        // 0,1,1,0,1,1,1,0
        // 4명이서 하는게임, 2번째, 3번말해야함
        return answer;
    }
}
