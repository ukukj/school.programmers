package LV2;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        boolean[] used = new boolean[numbers.length()];
        dfs(numbers, used, "");
        for (int x : set) {
            if (isPrime(x)) answer++;
        }
        return answer;
    }

    private void dfs(String numbers, boolean[] used, String cur) {
        if (!cur.isEmpty()) {
            set.add(Integer.parseInt(cur));
        }
        for (int i=0; i<numbers.length(); i++) {
            if (used[i]) continue;
            used[i] = true;
            dfs(numbers, used, cur+numbers.charAt(i));
            used[i] = false;
        }
    }

    private boolean isPrime(int x) {
        if (x<2) return false;
        if (x==2) return true;
        if (x%2==0) return false;
        int r = (int)Math.sqrt(x);
        for (int i=3; i<=r; i+=2) {
            if (x%i == 0) return false;
        }
        return true;
    }
}
