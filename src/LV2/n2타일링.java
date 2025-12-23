package LV2;

public class n2타일링 {
    public int solution(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
        long a = 1;
        long b = 2;
        for (int i=3; i<=n; i++){
            long c = (a+b) % 1000000007;
            a = b;
            b = c;
        }
        return (int) b;
    }
}
