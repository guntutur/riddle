/**
 * Created by zer0, the Maverick Hunter
 * on 07/10/21
 * Class: ArrayToLinkedList
 */
public class ArrayToLinkedList {

    static class Node {
        int data;
        Node next;
    }

    // Function to insert node
    // Time Complexity : O(n*n)
    static Node insert(Node root, int item) {
        Node temp = new Node();
        Node ptr;
        temp.data = item;
        temp.next = null;

        if (root == null) root = temp;
        else {
            ptr = root;
            while (ptr.next != null)
                ptr = ptr.next;
            ptr.next = temp;
        }
        return root;
    }

    static Node arrayToList(int arr[], int n) {
        long start = System.nanoTime();
        Node root = null;
        for (int i = 0; i < n; i++) root = insert(root, arr[i]);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("TIME ELAPSED FOR arrayToList() : " + timeElapsed);
        return root;
    }

    // Time Complexity : O(n)
    static Node insertOptimised(Node root, int item) {
        Node temp = new Node();
        temp.data = item;
        temp.next = root;
        root = temp;
        return root;
    }

    static Node arrayToListOptimised(int arr[], int n) {
        long start = System.nanoTime();
        Node root = null;
        for (int i = n - 1; i >= 0 ; i--) root = insertOptimised(root, arr[i]);
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("TIME ELAPSED FOR arrayToListOptimised() : " + timeElapsed);
        return root;
    }

    static void display(Node root) {
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.next;
        }
    }

    // Driver code
    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5};
        int n = arr.length;
        Node root = arrayToList(arr, n);
        display(root);
        System.out.println();
        Node rootOptimised = arrayToListOptimised(arr, n);
        display(rootOptimised);
    }
}

