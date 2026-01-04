package LV2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Deque<Long> list1 = new ArrayDeque<>();
        Deque<Long> list2 = new ArrayDeque<>();
        for (int num : queue1) {
            list1.add((long)num);
        }
        for (int num : queue2) {
            list2.add((long)num);
        }
        long sum1 = getSum(list1);
        long sum2 = getSum(list2);
        int limit = queue1.length * 3; // 같은 상태를 다시만나는 최대선
        if ((sum1 + sum2) % 2 == 1) return -1;
        while (answer <= limit) {
            if (sum1 == sum2) {
                return answer;
            }
            if (list1.size() == 0 || list2.size() == 0) {
                return -1;
            }
            else if (sum1 > sum2) {
                long element = list1.remove();
                list2.add(element);
                sum1 -= element;
                sum2 += element;
            } else {
                long element = list2.remove();
                list1.add(element);
                sum1 += element;
                sum2 -= element;
            }
            answer++;
        }
        return -1;
    }

    private long getSum(Deque<Long> list) {
        long sum = 0;
        for (long num : list) {
            sum += num;
        }
        return sum;
    }
}
