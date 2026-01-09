package LV2;

import java.util.*;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> time = new HashMap<>();
        int idx = 0;
        int out = 0;
        while (true) {
            boolean add = false;
            if (out == truck_weights.length) break;
            if (queue.isEmpty()) {
                queue.add(idx);
                time.put(idx, 0);
                idx++;
                add = true;
            }
            for (int key : time.keySet()) {
                time.put(key, time.get(key) + 1);
            }
            int first = queue.peek();
            if (time.get(first) == bridge_length + 1) {
                queue.poll();
                time.remove(first);
                out++;
            }

            if (!add && idx < truck_weights.length && getSum(queue, truck_weights) + truck_weights[idx] <= weight
                    && queue.size() < bridge_length) {
                queue.add(idx);
                time.put(idx, 1);
                idx++;
            }
            answer ++;
        }
        return answer;
    }
    private int getSum(LinkedList<Integer> queue, int[] truck_weights) {
        int sum = 0;
        for (int x : queue) {
            sum += truck_weights[x];
        }
        return sum;
    }
}
