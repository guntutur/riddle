/**
 * Created by zer0, the Maverick Hunter
 * on 26/11/20
 * Class: AdjacentCoin
 *
 * find the bug for edge cases, note that ONE COIN MUST BE REVERSED
 * in the case of long original adjacent, the original code return wrong result
 * it did not count the max adjacent where one coin must be reversed
 * to fix this, change the reverse initial value to -1
 * because fuck you that's why
 */
public class AdjacentCoin {

    public static void main(String[] args) {
        AdjacentCoin ac = new AdjacentCoin();
        // this is the edge case where the original solution would prevail
        // because the adjacent sum max is 5 pairs of 0s
        // BUT, the condition ONE COIN MUST BE REVERSED is not met
        // IF the condition is met, then the correct value would be 4, not 5
        int[] A = {0,0,0,0,0,0};
        System.out.println(ac.solution(A));
    }

    int solution(int[] A) {
        int n = A.length;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] == A[i + 1])
                result = result + 1;
        }
        int r = -1; // initial value is 0
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (i > 0) {
                if (A[i - 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            if (i < n - 1) {
                if (A[i + 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            r = Math.max(r, count);
        }
        return result + r;
    }

}
