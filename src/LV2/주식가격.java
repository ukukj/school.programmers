package LV2;

public class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i=0; i<prices.length; i++) {
            int x = prices[i];
            for (int j=i+1; j<prices.length; j++) {
                int y = prices[j];
                answer[i]++;
                if (x > y) {
                    break;
                }
            }
        }
        return answer;
    }
}
