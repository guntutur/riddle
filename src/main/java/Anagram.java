import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zer0, the Maverick Hunter
 * on 07/10/21
 * Class: Anagram
 */
public class Anagram {

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        String a = "tommarvoloriddle";
        String b = "iamlordvoldemort";
        System.out.println(anagram.isAnagram(a, b));
        System.out.println(anagram.isAnagramOptimised(a, b));
    }

    public boolean isAnagram(String a, String b) {
        long start = System.nanoTime();
// test for invalid input
        if (a == null || b == null || a.equals("") || b.equals("")) throw new IllegalArgumentException();

// initial quick test for non-anagrams
        if (a.length() != b.length()) return false;

        a = a.toLowerCase();
        b = b.toLowerCase();

// populate a map with letters and frequencies of String b
        Map<Character, Integer> map = new HashMap<>();

        for (int k = 0; k < b.length(); k++) {
            char letter = b.charAt(k);

            if (!map.containsKey(letter)) {
                map.put(letter, 1);
            } else {
                Integer frequency = map.get(letter);
                map.put(letter, ++frequency);
            }
        }

// test each letter in String a against data in the map
// return if letter is absent in the map or its  frequency is 0
// otherwise decrease the frequency by 1

        for (int k = 0; k < a.length(); k++) {
            char letter = a.charAt(k);

            if (!map.containsKey(letter))
                return false;

            Integer frequency = map.get(letter);

            if (frequency == 0)
                return false;
            else
                map.put(letter, --frequency);
        }
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("TIME ELAPSED FOR isAnagram() : " + timeElapsed);
// if the code got that far it is an anagram
        return true;
    }

    public boolean isAnagramOptimised(String A, String B) {
        long start = System.nanoTime();
        if (A == null || B == null) {
            return A == null && B == null;
        }
        A = A.toLowerCase();
        B = B.toLowerCase();
        char[] aArr = A.toCharArray();
        char[] bArr = B.toCharArray();
        Arrays.sort(aArr);
        Arrays.sort(bArr);
        String aSorted = new String(aArr);
        String bSorted = new String(bArr);

        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("TIME ELAPSED FOR isAnagramOptimised() : " + timeElapsed);

        return aSorted.equals(bSorted);
    }
}
