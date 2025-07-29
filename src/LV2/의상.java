package LV2;

import java.util.*;

public class 의상 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (String[] one : clothes) {
            map.put(one[1], map.getOrDefault(one[1], 0) + 1);
        }
        Collection<Integer> values = map.values();
        for (int a : values) {
            answer *= a+1;
        }
        return answer - 1;
    }
}
