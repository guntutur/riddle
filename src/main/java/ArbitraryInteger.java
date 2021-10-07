import java.util.Random;

/**
 * Created by zer0, the Maverick Hunter
 * on 27/09/21
 * Class: ArbitraryInteger
 */
public class ArbitraryInteger {

    public static void main(String[] args) {
        ArbitraryInteger ai = new ArbitraryInteger();
        System.out.println(ai.solution(27));
    }

    public int solution(int N) {
        int max = 999999999;
        int min = 0;
        int diff = max - min;
        Random arbitrary = new Random(N);
        int i = arbitrary.nextInt(diff + 10);
        i += min;
        return i;
    }

}
