/**
 * Created by zer0, the Maverick Hunter
 * on 01/05/20
 * Class: GamblingSolution
 *
 * ref :
 * - https://stackoverflow.com/questions/58055310/how-can-i-break-down-this-gambling-problem
 */
public class GamblingSolution {

    public static void main(String[] args) {
        System.out.println("Start The Test");
        GamblingSolution classSolution = new GamblingSolution();
        System.out.println(classSolution.solution(8,0));
    }

    public int solution(int N, int K) {
        int result = 0;
        while (N > 3 && K > 0) {
            if (N % 2 > 0) {
                N -= 1;
            } else {
                N /= 2;
                K -= 1;
            }
            result += 1;
        }
        return result + N - 1;
    }
}
