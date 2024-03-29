import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Anagrams {

    static List<String> anagramList = new ArrayList<>();

    //TODO: Calculate approximate times with util class method on all classes! Stay away from code duplication.
    public static void main(String[] args) {

        long startTime;
        long endTime;

        initializeAnagramLists();
        startTime = System.nanoTime();
        for(String str: anagramList){
            System.out.println(findMinimumAttemptForAnagram(str));
        }
        endTime = System.nanoTime();
        System.out.println("Calculated approximate time for first approach is: "+(endTime-startTime)+" nano seconds");
        //2139500 nano seconds

        System.out.println("--------------------------------");

        startTime = System.nanoTime();
        for(String str: anagramList){
            System.out.println(findMinimumAttemptForAnagramWithOnlyOneLoop(str));
        }
        endTime = System.nanoTime();
        System.out.println("Calculated approximate time for second approach is: "+(endTime-startTime)+" nano seconds");
        //473709 nano seconds

        System.out.println("--------------------------------");

        startTime = System.nanoTime();
        for(String str: anagramList){
            System.out.println(findMinimumAttemptForAnagramWithOnlyOneLoopWithoutLists(str));
        }
        endTime = System.nanoTime();
        System.out.println("Calculated approximate time for third approach is: "+(endTime-startTime)+" nano seconds");
        //385417 nano seconds
        //Without if control 36917 nano seconds -2
        /*I know sort is not important when stream converting to set. But I try for calculate the performance
        * and I saw sort in stream effects time to 1189375 nano seconds.So we can say that sort in stream is
        * performance killer! -3*/

    }

    private static void initializeAnagramLists(){
        anagramList.add("123122");
        anagramList.add("123456");
        anagramList.add("786678");
        anagramList.add("34568314");
    }

    /*TODO: Not only calculate the minimum attempt also add the method which converts the first
       half of the string to anagram.*/
    //First Approach
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

    //Second Approach
    private static int findMinimumAttemptForAnagramWithOnlyOneLoop(String str){

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
            if(!charListForSecondHalf.contains(charListForFirstHalf.get(i))){
                attemptNumber+=1;
            }
        }

        return attemptNumber;
    }

    //Third Approach
    private static int findMinimumAttemptForAnagramWithOnlyOneLoopWithoutLists(String str){

        int attemptNumber = 0;

        String strFirstHalf = str.substring(0,str.length()/2);
        String strSecondHalf = str.substring(str.length()/2);

        //Some educational codes with stream api
        /*if(strFirstHalf.chars().mapToObj(v-> (char) v).collect(Collectors.toSet())
                .equals(strSecondHalf.chars().mapToObj(v-> (char) v).collect(Collectors.toSet()))){
            System.out.println("No need to change!");
            return attemptNumber;
        }*/
        //2

        /*if(strFirstHalf.chars().mapToObj(v-> (char) v).sorted().collect(Collectors.toSet())
                .equals(strSecondHalf.chars().mapToObj(v-> (char) v).sorted().collect(Collectors.toSet()))){
            System.out.println("No need to change!");
            return attemptNumber;
        }*/
        //3

        /*Eğer birbirini daha fazla tekrar eden rakamların olduğu yarıda dolaşıp diğer yarıda var mı yok mu diye
        * bakarsam hatalı sonuç elde ederim mesela 123122 örneği. 122 olan yarıda dolaşıp 123 olan yarıda bu değerler
        * var mı yok mu diye bakarsam 0 elde ederim. Ama anagram için 1 değişiklik değerini yakalamak zorundayım.
        * Bundan dolayı küme yapısı kullandık. Küme elemanı olarak en fazla olan yarıda dolaşılacak az olan üzerinde
        * var mı yok mu kontrolü gerçekleştirilecek. Bu şekilde doğru sonuç elde edilecek. Bu algoritmanın eksikliği
        * zayıf yanı bu oldu. Maalesef en başta düşünüldüğü gibi tam olarak liste yapısından kaçamıyoruz. Belki algoritmada
        * liste yapısı yok ama stream api map yapıları set vs. var. Tam olarak istenilen çözüm değil bu. Fakat eklenen tüm
        * bu değişiklikler zamanlama açısından bir şey değiştirmedi. Süre hemen hemen aynı diyebiliriz üstelik nano
        * saniyerler cinsinden çalışmamıza rağmen.*/

        String x;
        String y;

        if(strFirstHalf.chars()
                .mapToObj(v-> (char) v)
                .collect(Collectors.toSet())
                .size()> strSecondHalf.chars().mapToObj(v-> (char) v).collect(Collectors.toSet()).size()){
            x = strFirstHalf;
            y = strSecondHalf;
        }
        else{
            x = strSecondHalf;
            y = strFirstHalf;
        }

        for(int i=0;i<strFirstHalf.length();i++){
            if(!y.contains(x.substring(i,i+1))){
                attemptNumber+=1;
            }
        }

        return attemptNumber;
    }
}
