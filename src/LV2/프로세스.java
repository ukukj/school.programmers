package LV2;

import java.util.ArrayDeque;

public class 프로세스 {
    public int solution(int[] priorities, int location) {
        int[] cnt = new int[10];            // 우선순위 1~9 가정
        for (int p : priorities) cnt[p]++;

        // cnt는 우선순위 i인게 cnt[i]개 있음
        int curMax = 9;
        while (curMax > 0 && cnt[curMax] == 0) curMax--;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) q.add(i);

        int order = 0;
        while (!q.isEmpty()) {
            int i = q.remove();
            int p = priorities[i];

            if (p == curMax) {             // 지금이 가장 높은 우선순위면 실행
                order++;
                if (i == location) return order;

                if (--cnt[p] == 0) {       // 다음 최대 우선순위로 갱신
                    while (curMax > 0 && cnt[curMax] == 0) curMax--;
                }
            } else {
                q.add(i);                  // 더 높은 우선순위가 있으므로 뒤로 보냄
            }
        }
        return -1; // 도달 불가
    }
}
