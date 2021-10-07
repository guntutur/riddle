/**
 * Created by zer0, the Maverick Hunter
 * on 26/11/20
 * Class: AddFive
 */
public class AddFive {

    public static void main(String[] args) {
        AddFive af = new AddFive();
//        int N = 268;
//        int N = 670;
//        int N = 0;
        int N = -999;
        System.out.println(af.solution(N));
    }

    public int solution(int N) {

        int theDigit = 5;

        if (N == 0) return theDigit * 10;

        int negate = N / Math.abs(N);
        N = Math.abs(N);
        int n = N;
        int maxValue = Integer.MIN_VALUE;
        int counter = 0;
        int pos = 1;

        while (n > 0) {
            counter++;
            n = n / 10;
        }

        for (int i = 0; i <= counter; i++) {

            int newValue = ((N / pos) * (pos * 10)) + (theDigit * pos) + (N % pos);
            if (newValue * negate > maxValue) maxValue = newValue * negate;
            pos = pos * 10;
        }

        return maxValue;
    }
}
