/**
 * Created by zer0, the Maverick Hunter
 * on 07/10/21
 * Class: BubbleSort
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort ob = new BubbleSort();
        int[] arr = {64, 34, 25, 0, 12, 22, 11, 0, 90};
        ob.solution(arr);
        System.out.println();
        ob.solutionOptimized(arr, arr.length);
        System.out.println();
        ob.solutionWithoutTmp(arr);
    }

    public void solution(int[] arr) {
//        long start = System.currentTimeMillis();
        long start = System.nanoTime();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

        for (int j : arr) System.out.print(j + " ");
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("TIME ELAPSED FOR solution() : " + timeElapsed);
    }

    public void solutionOptimized(int[] arr, int n) {
        long start = System.nanoTime();
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // break the leg, i mean loop
            if (!swapped) break;
        }

        int k;
        for (k = 0; k < n; k++)
            System.out.print(arr[k] + " ");
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("TIME ELAPSED FOR solutionOptimized() : " + timeElapsed);
    }

    public void solutionWithoutTmp(int[] arr) {
        long start = System.nanoTime();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                // arr[j + 1] = 10, x;
                // arr[j] = 15, y;
                if (arr[j] > arr[j + 1]) {
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                    arr[j + 1] = arr[j + 1] + arr[j];
                }

        int k;
        for (k = 0; k < n; k++)
            System.out.print(arr[k] + " ");
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("TIME ELAPSED FOR solutionWithoutTmp() : " + timeElapsed);
    }
}
