import java.util.ArrayList;
import java.util.List;

public class SubstringRemoval {

    static List<String> stringList = new ArrayList<>();

    public static void main(String[] args) {

        initializeStrings();
        for (String str: stringList){
            System.out.println(getMinLength(str));
        }
    }

    private static List<String> initializeStrings(){
        stringList.add("BABBA");
        stringList.add("BABB");
        stringList.add("AABBBAB");

        return stringList;
    }

    //TODO: Change the getMinLength function only one loop version.
    private static int getMinLength(String seq){
        while(seq.indexOf("AB") != -1){
            seq = seq.replace("AB","");
        }

        while(seq.indexOf("BB") != -1){
            seq = seq.replace("BB","");
        }

        return seq.length();
    }
}
