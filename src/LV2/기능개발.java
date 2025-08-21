package LV2;

import java.util.ArrayList;
import java.util.List;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] need = new int[progresses.length];    //7, 3, 9
        for (int i=0; i<progresses.length; i++) {
            int left = 100 - progresses[i];
            int mok = left / speeds[i];
            int na  = left % speeds[i];
            if (na > 0) {
                need[i] = mok + 1;
            } else {
                need[i] = mok;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<need.length; i++) {
            list.add(need[i]);
        }
        int day = 1;
        int totalCnt = 0;
        List<Integer> ans = new ArrayList<>();
        int idx = 0;
        while (totalCnt != progresses.length) {
            int cnt = 0;
            if (list.get(idx) == day) {
                cnt ++;
                idx ++;
                for (int i=idx; i<list.size(); i++) {
                    if (day >= list.get(i)) {
                        cnt ++;
                        idx ++;
                    } else {
                        break;
                    }
                }
                ans.add(cnt);
            }
            totalCnt += cnt;
            day++;
        }

        int[] answer = new int[ans.size()];
        for (int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
