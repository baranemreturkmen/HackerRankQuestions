import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CalculateSmallestPositiveInteger {

    static List<List<Integer>> integerLists = new ArrayList<>();

    public static void main(String[] args) {

        initializeIntegerLists();
        for(List<Integer> integerList: integerLists){
            System.out.println(calculateSmallestPositiveInteger(integerList));
        }

    }

    private static void initializeIntegerLists(){
        List<Integer> integerList1 = new ArrayList<>();
        integerList1.add(1);
        integerList1.add(3);
        integerList1.add(6);
        integerList1.add(4);
        integerList1.add(1);
        integerList1.add(2);

        List<Integer> integerList2 = new ArrayList<>();
        integerList2.add(1);
        integerList2.add(2);
        integerList2.add(3);

        List<Integer> integerList3 = new ArrayList<>();
        integerList3.add(-1);
        integerList3.add(-3);

        integerLists.add(integerList1);
        integerLists.add(integerList2);
        integerLists.add(integerList3);

        //Create complex list
        List<Integer> complexIntegerList = new ArrayList<>();
        for(int i=0;i<5;i++){
            complexIntegerList.add((int) (100_000*Math.random()));
        }
        integerLists.add(complexIntegerList);

        //Create more complex list :)
        List<Integer> moreComplexIntegerList = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<10;i++){
            //int number = random.nextInt(max - min) + min;
            moreComplexIntegerList.add(random.nextInt(100_000 + 100_000) -100_000);
        }
        System.out.println(moreComplexIntegerList);
        integerLists.add(moreComplexIntegerList);
    }

    private static int calculateSmallestPositiveInteger(List<Integer> integerList){
        int minValue = integerList.stream().filter(v -> v>0).mapToInt(v -> v).min().orElse(0);
        int maxValue = integerList.stream().mapToInt(v -> v).max().orElse(0);
        int value = 0;

        if(maxValue>0){
            for(int i=minValue;i<=maxValue;i++){
                if(!integerList.contains(i)){
                    value = i;
                    break;
                }
            }
            if(value==0){
                return maxValue+1;
            }
            return value;
        }

        return 1;
    }

}
