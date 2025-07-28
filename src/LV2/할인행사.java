package LV2;

import java.util.HashMap;
import java.util.Map;

public class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<discount.length; i++) {
            boolean can = true;
            if (i>=10) {
                String item = discount[i-10];
                map.put(item, map.getOrDefault(item, 0) - 1);
            }
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
            // 만족하는지
            for (int j=0; j<want.length; j++) {
                String item = want[j];
                int need = number[j];
                if (map.getOrDefault(item, 0) != need) {
                    can = false;
                    break;
                }
            }
            if (can) {
                answer++;
            }

        }
        return answer;
    }
}
