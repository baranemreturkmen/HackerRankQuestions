import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SeparateAAndBCountAttempts {

    static List<String> AAndBList = new ArrayList<>();

    public static void main(String[] args) {
        initializeAAndBStringList();
        for(String str: AAndBList){
            System.out.println(separateAAndBCountAttempts(str));
        }
    }

    //TODO: Not count only, also convert the Strings balanced A and B format!
    public static int separateAAndBCountAttempts(String s){

        if (s == null || s.isEmpty()) return 0;

        int countB = 0; //keep a count of Bs
        int removals = 0; //keep a count of removed As

        for (int i = 0; i < s.length(); i++) {

            //For this block I made my own 'AB' catcher!
            if (s.charAt(i) == 'A') {
                if (countB > 0) { // only if there are Bs before this A
                    ++removals; // remove this A
                    --countB; // and decrement the Bs count
                }
            } else {
                ++countB; // keep incrementing the Bs count
            }
        }
        return removals;

    }

    public static void initializeAAndBStringList(){
        AAndBList.add("BAAABAB");
        AAndBList.add("BBABAA");
        AAndBList.add("AABBBB");
        AAndBList.add("BAABABABAB");
    }

}
