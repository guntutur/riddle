/**
 * Created by zer0, the Maverick Hunter
 * on 01/05/20
 * Class: Application
 *
 * ref :
 * - https://mkyong.com/java/java-check-if-array-contains-a-certain-value/
 * - https://stackoverflow.com/questions/56512989/get-number-of-reporting-soldier
 * - https://mkyong.com/java/java-bubble-sort-example/
 */
public class ArmySolution {

    public static void main(String[] args) {
        System.out.println("Start The Test");
        ArmySolution classSolution = new ArmySolution();
        int[] ranks = {3,4,3,0,2,2,3,0,0};
        classSolution.solution(ranks);
    }

    public void solution(int[] ranks) {

        boolean isSorted;
        int temp;
        int arrLength = ranks.length;

        for (int i = 0; i < arrLength; i++) {

            isSorted = true;
            for (int j = 1; j < (arrLength - i); j++) {

                if (ranks[j - 1] > ranks[j]) {
                    temp = ranks[j - 1];
                    ranks[j - 1] = ranks[j];
                    ranks[j] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                countRank(ranks);
                break;
            }
        }
        // write your code in Java SE 8
    }

    public void countRank(int[] ranks) {

        int soldierWhoCanReport = 0;
        for (int rank : ranks) {
            int upperClass = rank + 1;
            if (contains(ranks, upperClass)) {
                soldierWhoCanReport++;
            }
            System.out.println(rank);
        }
        System.out.println("-------");
        System.out.println(soldierWhoCanReport);
    }

    public static boolean contains(final int[] array, final int v) {

        boolean result = false;

        for(int i : array){
            if(i == v){
                result = true;
                break;
            }
        }

        return result;
    }
}
