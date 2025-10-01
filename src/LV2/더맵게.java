package LV2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class 더맵게 {
    public int solution(int[] scoville, int k) {
        int cnt = 0;
        boolean success = false;
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for (int i : scoville) {
            minHeap.add(i);
        }
        while (true) {
            if (minHeap.isEmpty()) {
                break;
            }
            if (minHeap.peek() >= k) {
                success = true;
                break;
            }
            if (minHeap.size() == 1) {
                break;
            }
            int remove1 = minHeap.remove();
            int remove2 = minHeap.remove();
            int val = remove1 + 2 * remove2;
            minHeap.add(val);
            cnt ++;
        }

        if (success) return cnt;
        return -1;
    }
}
