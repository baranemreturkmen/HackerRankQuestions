import java.util.ArrayList;
import java.util.List;

public class SubstringRemoval {

    static List<String> stringList = new ArrayList<>();
    private static final long NANO_TO_MILLISECONDS_CONSTANT = 1_000_000;

    public static void main(String[] args) {

        long startTime;
        long endTime;

        initializeStrings();
        startTime = System.nanoTime();
        for (String str: stringList){
            System.out.println(getMinLength(str));
        }
        endTime = System.nanoTime();
        System.out.println("Calculated approximate time for first approach is: "+(endTime-startTime)+" nano seconds");
        //132083 nano seconds

        System.out.println("--------------------------");

        startTime = System.nanoTime();
        for (String str: stringList){
            System.out.println(getMinLengthWithOnlyOneLoop(str));
        }
        endTime = System.nanoTime();
        System.out.println("Calculated approximate time for second approach is: "+(endTime-startTime)+" nano seconds");
        //40667 nano seconds

        //Second approach is approximately 4 times faster than firs approach
    }

    private static List<String> initializeStrings(){
        stringList.add("BABBA");
        stringList.add("BABB");
        stringList.add("AABBBAB");

        return stringList;
    }

    private static int getMinLength(String seq){
        while(seq.indexOf("AB") != -1){
            seq = seq.replace("AB","");
        }

        while(seq.indexOf("BB") != -1){
            seq = seq.replace("BB","");
        }

        return seq.length();
    }

    private static int getMinLengthWithOnlyOneLoop(String seq){
        while(seq.indexOf("AB") != -1 || seq.indexOf("BB") != -1){
            if(seq.indexOf("AB") != -1){
                seq = seq.replace("AB","");
            }
            else if(seq.indexOf("BB") != -1){
                seq = seq.replace("BB","");
            }
        }

        return seq.length();
    }
}
