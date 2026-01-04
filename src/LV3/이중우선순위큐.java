package LV3;

import java.util.LinkedList;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i=0; i<operations.length; i++) {
            String oper = operations[i];
            if (oper.startsWith("I")) {
                String numStr = oper.split(" ")[1];
                int num = Integer.parseInt(numStr);
                queue.add(num);
            }
            else if (oper.startsWith("D 1")) {
                removeMax(queue);
            }
            else {
                removeMin(queue);
            }
        }
        if (queue.size() == 0) return new int[2];
        return new int[]{getMax(queue), getMin(queue)};
    }

    private void removeMin(LinkedList<Integer> queue) {
        int min = Integer.MAX_VALUE;
        for (int num : queue) {
            min = Math.min(min, num);
        }
        queue.remove(Integer.valueOf(min));
    }

    private void removeMax(LinkedList<Integer> queue) {
        int max = Integer.MIN_VALUE;
        for (int num : queue) {
            max = Math.max(max, num);
        }
        queue.remove(Integer.valueOf(max));
    }

    private int getMin(LinkedList<Integer> queue) {
        int min = Integer.MAX_VALUE;
        for (int num : queue) {
            min = Math.min(min, num);
        }
        return min;
    }

    private int getMax(LinkedList<Integer> queue) {
        int max = Integer.MIN_VALUE;
        for (int num : queue) {
            max = Math.max(max, num);
        }
        return max;
    }
}
