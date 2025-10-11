package LV2;

import java.util.Stack;

public class 택배상자 {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack();
        int cnt = 0;
        int now = 1;
        while (true) {
            if (cnt == order.length) break;
            if (order[cnt] == now) {
                cnt ++;
            } else {
                if (!stack.isEmpty()) {
                    int peek = stack.peek();
                    if (order[cnt] == peek) {
                        cnt ++;
                        stack.pop();
                        continue;
                    } else {
                        if (now>=order.length) {
                            break;
                        }
                    }
                }
                stack.push(now);
            }
            now ++;
        }

        return cnt;
    }
}
