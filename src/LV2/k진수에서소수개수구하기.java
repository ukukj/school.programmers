package LV2;


public class k진수에서소수개수구하기 {
    public int solution(int n, int k) {
        int cnt = 0;

        // 211020101011
        String jinStr = Integer.toString(n, k);
        for (int i=0; i<jinStr.length(); i++) {
            for (int j=i+1; j<jinStr.length()+1; j++) {
                String str = jinStr.substring(i,j);
                Long x = Long.parseLong(str);
                if (!str.contains("0") && isPrime(x)) {
                    boolean noLeft  = i == 0;
                    boolean noRight = j == jinStr.length();
                    if (str == jinStr) {
                        cnt ++;
                    }
                    else if (noLeft && j!=jinStr.length() &&jinStr.charAt(j) == '0') {
                        cnt ++;
                    }
                    else if (noRight && i!=0 && jinStr.charAt(i-1) == '0') {
                        cnt ++;
                    }
                    else if (!noLeft && !noRight && jinStr.charAt(i-1) == '0' && jinStr.charAt(j) == '0') {
                        cnt ++;
                    }
                }
            }
        }

        return cnt;
    }
    private boolean isPrime(long x) {
        if (x < 2) return false;
        if (x==2) return true;
        if (x % 2 == 0) return false;
        long r = (long)Math.sqrt(x);
        for (long d = 3; d <= r; d += 2) {
            if (x % d == 0) return false;
        }
        return true;
    }
}
