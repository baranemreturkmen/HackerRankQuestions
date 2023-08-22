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
        System.out.println("-----------------------------------");

        for(String str: AAndBList){
            System.out.println(createSeparatedAAndBStrings(str));
        }
    }

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

    //TODO: Write second version of this method. Do not balanced. Delete the chars like question requirement.
    //İf first half has more A's than B's convert first half to A's or vice versa.
    public static String createSeparatedAAndBStrings(String s){

        if (s == null || s.isEmpty()) return "String empty or null!";
        else if(s.indexOf("ABA")==-1 && s.indexOf("BAB")==-1) return s;

        String strFirstHalf;
        String strSecondHalf;

        if(s.length()%2!=0){
            strFirstHalf = s.substring(0,(s.length()/2)+1);
            strSecondHalf = s.substring((s.length()/2)+1);
        }
        else{
            strFirstHalf = s.substring(0,(s.length()/2));
            strSecondHalf = s.substring((s.length()/2));
        }

        long firstHalfACount = strFirstHalf.chars().mapToObj(e->(char)e).filter(e->e.equals('A')).count();
        long firstHalfBCount = strFirstHalf.chars().mapToObj(e->(char)e).filter(e->e.equals('B')).count();

        //Convert first half A
        if(firstHalfACount>firstHalfBCount){
           strFirstHalf = strFirstHalf.replace("B","A");
           strSecondHalf = strSecondHalf.replace("A","B");
        }
        //Convert first half B
        else{
           strFirstHalf = strFirstHalf.replace("A","B");
           strSecondHalf = strSecondHalf.replace("B","A");
        }

        return strFirstHalf+strSecondHalf;
    }

    public static void initializeAAndBStringList(){
        AAndBList.add("BAAABAB");
        AAndBList.add("BBABAA");
        AAndBList.add("AABBBB");
        AAndBList.add("BAABABABAB");
    }

}
