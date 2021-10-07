/**
 * Created by zer0, the Maverick Hunter
 * on 27/09/21
 * Class: MultiplyString
 */
public class MultiplyString {

    public static void main(String[] args) {
        MultiplyString ms = new MultiplyString();
        System.out.println(ms.solution(4, "two"));
    }

    public int solution(int D, String S) {
        int res = 0;
        switch (S) {
            case "one":
                res = D;
                break;
            case "two":
                res = D*2;
            break;
            case "three":
                res = D*3;
            break;
            case "four":
                res = D*4;
            break;
            case "five":
                res = D*5;
            break;
        }

        return res;
    }

}
