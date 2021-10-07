/**
 * Created by zer0, the Maverick Hunter
 * on 27/09/21
 * Class: BinaryRepresentation
 */
public class BinaryRepresentation {

    public static void main(String[] args) {
        BinaryRepresentation br = new BinaryRepresentation();
        System.out.println(br.solution(3, 7));
    }

    public int solution(int A, int B) {
        int mult = A * B;
        String theBinary = Integer.toString(mult,2);
        String[] binaryArray = theBinary.split("");
        int result = 0;

        for (String a : binaryArray){
            if(a.equals("1")) result++;
        }

        return result;
    }

}
