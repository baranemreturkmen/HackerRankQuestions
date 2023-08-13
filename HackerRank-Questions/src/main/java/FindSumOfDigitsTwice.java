import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FindSumOfDigitsTwice {

    static List<Integer> integerList = new ArrayList<>();

    public static void main(String[] args) {

        initializeIntegerList();
        for (Integer intValue: integerList){
            System.out.println(calculateSumOfDigitsTwice(intValue));
        }

    }

    private static void initializeIntegerList(){
        integerList.add(14);
        integerList.add(10);
        integerList.add(99);
        integerList.add(1);
        integerList.add(3);
        integerList.add(469);
        integerList.add(479);
        integerList.add(79);
        integerList.add(300);
        integerList.add(312);
    }

    private static int calculateSumOfDigitsTwice(int input){
        //input 14, 10, 99, etc. input between 1... 500
        //from 469 479 begin ten thousands

        int hundredsDigit = input / 100;
        int tensDigit;
        if(hundredsDigit > 0){
            tensDigit = (input % 100) / 10;
        }
        else{
            tensDigit = input / 10;
        }
        int unitsDigit = input % 10;

        int digitsSum = hundredsDigit + tensDigit + unitsDigit;
        int newDigitSum;
        int i=input;

        int thousandsDigit = 0;
        int tenThousandsDigit = 0;

        while(true){
            i++;
            hundredsDigit = i / 100;
            if(hundredsDigit > 0){
                tensDigit = (i % 100) / 10;
            }
            else{
                tensDigit = i / 10;
            }
            if (hundredsDigit > 10){
                hundredsDigit = (i % 1000) / 100;
                thousandsDigit = i / 1000;
            }
            if(thousandsDigit > 10){
                thousandsDigit = (i % 10000) / 1000;
                tenThousandsDigit = i /10000;
            }

            unitsDigit = i % 10;

            newDigitSum = hundredsDigit + tensDigit + unitsDigit + thousandsDigit + tenThousandsDigit;

            if(digitsSum*2 == newDigitSum){
                break;
            }
        }

        return i;
    }

}
