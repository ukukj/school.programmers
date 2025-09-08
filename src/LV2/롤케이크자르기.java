package LV2;

import java.util.*;

public class 롤케이크자르기 {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> right = new HashMap<>();
        Set<Integer> left = new HashSet<>();
        for (int t : topping) {
            right.put(t, right.getOrDefault(t,0) + 1);
        }
        int rightCnt = right.size();
        for (int i=0; i<topping.length; i++) {
            int x = topping[i];
            int cnt = right.get(x) - 1;
            if (cnt == 0) {
                right.remove(x);
                rightCnt --;
            } else {
                right.put(x, cnt);
            }
            left.add(x);
            int leftCnt = left.size();

            if (rightCnt == leftCnt) {
                answer++;
            }
        }
        return answer;
    }
}
