/**
 * Created by zer0, the Maverick Hunter
 * on 27/09/21
 * Class: MissingRolls
 */
public class MissingRolls {

    public static void main(String[] args) {
        MissingRolls mr = new MissingRolls();
        int[] A = new int [] {1, 2, 3, 4};
        for (int i : mr.solution(A, 4, 6)) {
            System.out.println(i);
        }
    }

    public int[] solution(int[] A, int F, int M) {
        int sumA = 0;
        for(int element: A) sumA += element;

        int theMissingOne = M * (F + A.length) - sumA;
        double actualRoll = theMissingOne / (double)F;
        int eachRoll = theMissingOne / F;
        int remove = theMissingOne % F;

        // impossible case
        if(actualRoll < 0 || actualRoll > 6) return new int[] {0};

        int[] ans = new int[F];

        for(int i = 0; i < F; i++){
            ans[i] = eachRoll + (remove <= 0?0:1);
            remove--;
        }

        return ans;
    }
}
