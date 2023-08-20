import java.util.*;
import java.util.stream.Collectors;

public class ReverseString {

    //TODO: Initialize more example and calculate each approaches perfomances.
    public static void main(String[] args) {
        String reverse = "reverse";

        System.out.println("Reverse String Without Any Build In Funciton");
        System.out.println(reverseWithoutAnyBuildInFunciton(reverse));

        System.out.println("-------------------------------------");

        System.out.println("Reverse String With StringBuilder");
        System.out.println(reverseWithBuiltInFunctionViaStringBuilder(reverse));

        System.out.println("-------------------------------------");

        System.out.println("Reverse String With ByteArray");
        System.out.println(reverseStringViaByteArray(reverse));

        System.out.println("-------------------------------------");

        System.out.println("Reverse String With CharArray");
        System.out.println(reverseStringViaCharArray(reverse));

        System.out.println("-------------------------------------");

        System.out.println("Reverse String With CharacterList");
        System.out.println(reverseStringViaCharacterList(reverse));

        System.out.println("-------------------------------------");

        System.out.println("Reverse String With ListIterator");
        System.out.println(reverseStringViaListIterator(reverse));

        System.out.println("-------------------------------------");

        System.out.println("Reverse String With StringBuffer");
        System.out.println(reverseStringViaStringBuffer(reverse));

        System.out.println("-------------------------------------");

        System.out.println("Reverse String With Stack");
        System.out.println(reverseStringViaStack(reverse));
    }

    private static String reverseWithoutAnyBuildInFunciton(String str){
        String reverseStr = "";
        char ch;

        for (int i=0; i<str.length(); i++)
        {
            ch= str.charAt(i); //extracts each character
            reverseStr= ch+reverseStr; //adds each character in front of the existing string
        }

        return reverseStr;
    }

    private static String reverseWithBuiltInFunctionViaStringBuilder(String str){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);

        return stringBuilder.reverse().toString();
    }

    private static String reverseStringViaByteArray(String str){
        // getBytes() method to convert string
        // into bytes[].
        byte[] strAsByteArray = str.getBytes();

        byte[] result = new byte[strAsByteArray.length];

        // Store result in reverse order into the
        // result byte[]
        for (int i = 0; i < strAsByteArray.length; i++)
            result[i] = strAsByteArray[strAsByteArray.length - i - 1];

        return new String(result);
    }

    private static String reverseStringViaCharArray(String str){
        // convert String to character array
        // by using toCharArray
        char[] try1 = str.toCharArray();
        String reverseStr = "";

        for (int i = try1.length - 1; i >= 0; i--)
            reverseStr += String.valueOf(try1[i]);

        return reverseStr;
    }

    private static String reverseStringViaCharacterList(String str){
        String reverseStr = "";
        List<Character> charList = str.chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());

        for(int i= charList.size()-1;i>=0;i--){
            reverseStr += charList.get(i).toString();
        }

        return reverseStr;
    }

    private static String reverseStringViaListIterator(String str){
        String reverseStr = "";
        char[] charArray = str.toCharArray();
        List<Character> characterList = new ArrayList<>();

        for (char c : charArray)
            characterList.add(c);

        Collections.reverse(characterList);
        ListIterator li = characterList.listIterator();
        while (li.hasNext())
            reverseStr += li.next();

        return reverseStr;
    }

    private static String reverseStringViaStringBuffer(String str){
        StringBuffer stringBuffer = new StringBuffer(str);

        return stringBuffer.reverse().toString();
    }

    private static String reverseStringViaStack(String str){
        Stack<Character> stack=new Stack<>();

        for(char c:str.toCharArray())
        {
            //pushing all the characters
            stack.push(c);
        }

        String strReverse="";

        while(!stack.isEmpty())
        {
            //popping all the chars and appending to temp
            strReverse+=stack.pop();
        }

        return strReverse;
    }

}
