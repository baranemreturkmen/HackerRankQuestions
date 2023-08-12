import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Anagrams {

    static List<String> anagramList = new ArrayList<>();

    public static void main(String[] args) {

        initializeAnagramLists();

        for(String str: anagramList){
            System.out.println(findMinimumAttemptForAnagram(str));
            System.out.println("---------------------");
        }

    }

    private static void initializeAnagramLists(){
        anagramList.add("123122");
        anagramList.add("123456");
        anagramList.add("786678");
        anagramList.add("34568314");
    }

    /*TODO: Not only calculate the minimum attempt also add the method which converts the first
       half of the string to anagram.*/
    private static int findMinimumAttemptForAnagram(String str){

        int attemptNumber = 0;

        String strFirstHalf = str.substring(0,str.length()/2);
        String strSecondHalf = str.substring(str.length()/2);

        List<Character> charListForFirstHalf = strFirstHalf.chars()
                .mapToObj(e->(char)e).sorted().collect(Collectors.toList());

        List<Character> charListForSecondHalf = strSecondHalf.chars()
                .mapToObj(e->(char)e).sorted().collect(Collectors.toList());

        if(charListForFirstHalf.equals(charListForSecondHalf)){
            System.out.println("No need to change!");
            return attemptNumber;
        }

        for(int i=0;i<charListForFirstHalf.size();i++){
            for(int j=0;j<charListForSecondHalf.size();j++){
                if(charListForFirstHalf.get(i).equals(charListForSecondHalf.get(j))){
                    break;
                }
                else if(j==charListForSecondHalf.size()-1){
                    attemptNumber+=1;
                }
            }
        }

        return attemptNumber;
    }
}
