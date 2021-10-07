import java.util.Arrays;

/**
 * Created by zer0, the Maverick Hunter
 * on 27/09/21
 * Class: SmallestPositiveInteger
 */
public class SmallestPositiveInteger {

    public static void main(String[] args) {
        SmallestPositiveInteger spi = new SmallestPositiveInteger();
        int[] test = new int [] {-1, -3};
        System.out.println(spi.solution(test));
    }

    public int solution(int[] A) {
        int n = A.length;

        boolean[] present = new boolean[n + 1];

        for (int value : A) {
            if (value > 0 && value <= n)
                present[value] = true;
        }

        for (int i = 1; i <= n; i++)
            if (!present[i])
                return i;

        return n + 1;
    }

}
