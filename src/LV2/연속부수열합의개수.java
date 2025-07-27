package LV2;

import java.util.HashSet;
import java.util.Set;

public class 연속부수열합의개수 {

    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        // 배열 확장
        int[] extended = new int[elements.length * 2];
        for (int i=0; i<elements.length * 2; i++) {
            extended[i] = elements[i%elements.length];
        }
        for (int i=1; i<elements.length+1; i++) {
            for (int j=0; j<elements.length; j++) {
                int sum = 0;
                for (int k=0; k<i; k++) {
                    sum += extended[j+k];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}
