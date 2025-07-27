package LV2;

public class 예상대진표 {
    public int solution(int n, int a, int b) {
        int answer = 1;

        while (true) {
            if (Math.abs(a-b) == 1) {
                if (a>b) {
                    if (a/2 == b/2 +1) {
                        break;
                    }
                } else {
                    if (b/2 == a/2 +1) {
                        break;
                    }
                }
            }
            a = getNext(a);
            b = getNext(b);
            answer ++;
        }

        return answer;
    }
    private int getNext(int num) {
        if (num % 2 ==0) {
            num = num / 2;
        } else{
            num = num / 2 + 1;
        }
        return num;
    }
}
