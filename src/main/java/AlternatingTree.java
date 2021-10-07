/**
 * Created by zer0, the Maverick Hunter
 * on 26/11/20
 * Class: AlternatingTree
 */
public class AlternatingTree {

    public static void main(String[] args) {
        AlternatingTree at = new AlternatingTree();
//        int[] A = {3,4,5,3,7};
        int[] A = {1,2,2,4};
//        int[] A = {1,3,1,2};
        System.out.println(at.solution(A));
    }

    public int solution(int[] A) {

        if (alreadyAesthetic(A)) return 0;
        int patternCount = 0;
        for (int j = 0; j < A.length; j++) {
            int[] newA = copyArray(A,j);
            if (alreadyAesthetic(newA)) patternCount++;
        }
        if (patternCount == 0) return -1;
        else return patternCount;
    }

    private int[] copyArray(int[] array, int indexToBeRemoved) {
        int arrLength = array.length;
        int[] newA = new int[arrLength - 1];
        int tempK = 0;
        for (int k = 0; k < arrLength; k++) {
            if (k != indexToBeRemoved) newA[tempK++] = array[k];
        }
        return newA;
    }

    private Boolean alreadyAesthetic(int[] array) {
        int newArrLength = array.length;
        int isIncreasingFlag = 0;
        for (int i = 0; i < newArrLength; i++) {
            if (isIncreasingFlag == 0) {
                if (array[i] < array[i + 1]) isIncreasingFlag = 1;
                else isIncreasingFlag = 2;
            }
            else {
                if (isIncreasingFlag == 1) {
                    if (i % 2 == 1 && array[i] > array[i - 1]) { }
                    else if (i % 2 == 0 && array[i] < array[i - 1]) { }
                    else { return false; }
                }
                else {
                    if (i % 2 == 1 && array[i] < array[i - 1]) { }
                    else if (i % 2 == 0 && array[i] > array[i - 1]) { }
                    else { return false; }
                }
            }
        }
        return true;
    }
}
