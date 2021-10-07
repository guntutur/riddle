import java.util.*;

/**
 * Created by zer0, the Maverick Hunter
 * on 01/05/20
 * Class: StringSolution
 *
 * ref :
 * - https://leetcode.com/playground/4cbHFo7z
 * - https://leetcode.com/discuss/interview-question/330356/Amazon-or-Online-Assessment-2019-or-Longest-string-without-3-consecutive-characters
 */
public class StringSolution {

    public static void main(String[] args) {
        System.out.println("Start The Test");
        StringSolution classSolution = new StringSolution();
        System.out.println(classSolution.solution(5,3));
    }

    public String solution(int A, int B) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('a', A);
        map.put('b', B);

        return shuffleString(map);
    }

    public static String shuffleString(Map<Character, Integer> map){
        Queue<Node> q = new PriorityQueue<>((a, b) -> b.val - a.val);

        for(Character l : map.keySet()){
            if(map.get(l) != 0){
                Node n = new Node(map.get(l) ,l);
                q.offer(n);
            }
        }

        StringBuilder res = new StringBuilder();
        while(!q.isEmpty()){
            Node first = q.poll();
            if(res.length() != 0 && res.charAt(res.length() - 1) == first.letter){
                if(q.isEmpty()) return res.toString();
                else {
                    Node second = q.poll();
                    res.append(second.letter);
                    second.val--;
                    if(second.val != 0) q.offer(second);
                    q.offer(first);
                }
            }
            else{
                int limit = Math.min(2, first.val);
                for(int i = 0; i < limit; i++){
                    res.append(first.letter);
                    first.val--;
                }
                if(first.val != 0){
                    q.offer(first);
                }
            }
        }
        return res.toString();
    }
}

class Node{
    int val;
    char letter;
    public Node(int val, char c){
        this.val = val;
        this.letter = c;
    }
}
