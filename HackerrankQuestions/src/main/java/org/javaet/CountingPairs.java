package org.javaet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class CountingPairs {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);

        List<Integer> numbers2 = new ArrayList<>();
        numbers2.add(1);
        numbers2.add(2);

        List<Integer> numbers3 = new ArrayList<>();
        numbers3.add(1);
        numbers3.add(1);
        numbers3.add(2);
        numbers3.add(2);
        numbers3.add(3);
        numbers3.add(3);

        List<Integer> numbers4 = new ArrayList<>();
        numbers4.add(1);
        numbers4.add(2);
        numbers4.add(3);
        numbers4.add(4);
        numbers4.add(5);
        numbers4.add(6);

        List<Integer> numbers5 = new ArrayList<>();
        numbers5.add(1);
        numbers5.add(2);
        numbers5.add(5);
        numbers5.add(6);
        numbers5.add(9);
        numbers5.add(10);

        List<Integer> numbers6 = new ArrayList<>();
        numbers6.add(7);
        numbers6.add(7);

        List<Integer> numbers7 = new ArrayList<>();
        numbers7.add(1);
        numbers7.add(4);
        numbers7.add(2);
        numbers7.add(5);
        numbers7.add(7);
        numbers7.add(6);
        numbers7.add(3);

        List<Integer> numbers8 = new ArrayList<>();
        numbers8.add(0);
        numbers8.add(5);
        numbers8.add(1);
        numbers8.add(2);
        numbers8.add(6);
        numbers8.add(4);
        numbers8.add(12);
        numbers8.add(9);
        numbers8.add(10);
        numbers8.add(11);
        numbers8.add(7);
        numbers8.add(8);

        List<Integer> numbers9 = new ArrayList<>();
        numbers9.add(1);
        numbers9.add(3);
        numbers9.add(5);
        numbers9.add(6);
        numbers9.add(-1);

        System.out.println(countPairs(numbers,1));
        System.out.println(countPairs(numbers2,0));
        System.out.println(countPairs(numbers3,1));
        System.out.println(countPairs(numbers4,2));
        System.out.println(countPairs(numbers5,2));
        System.out.println(countPairs(numbers6,0));
        System.out.println(countPairs(numbers7,3));
        System.out.println(countPairs(numbers8,1));
        System.out.println(countPairs(numbers9,1));
    }

    public static int countPairs(List<Integer> numbers, int k){
        int k_differenceSum = 0;
        HashSet<Integer> numbersSet = new HashSet<>(numbers);
        List<Integer> numbersOrdered;
        numbersOrdered = numbersSet.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        BinaryOperator<Integer> accumulate = (acc, v) -> acc + v;
        int checkNegativeElementExists = numbers.stream().filter(x->x<0).reduce(0,accumulate);

        /*Validations
         *If we compare pairs in list, list must contain 2 element at least.
         *Algorithm checks the difference between list elements so negative elements in list will
         * break the algorithm*/
        if(k==0 && numbers.size()>1 && checkNegativeElementExists>=0){
            k_differenceSum += numbersOrdered.size();
        }

        else if(k>0 && numbers.size()>1 && checkNegativeElementExists>=0){
                for (var variable: numbersOrdered ) {
                    for(int i=0;i<numbersOrdered.size();i++){
                        if (k==variable-numbersOrdered.get(i)){
                            k_differenceSum+=1;
                        }
                    }
                }
        }

        /*"\u001B[31m" makes the warning writing color red. After warning writing
         *"\u001B[0m" will make writing color default again.*/
        else{
            System.out.println("\u001B[31m" + "List size must be bigger than 1 and list " +
                    "can not contains negative elements! Therefore method will return 0."+"\u001B[0m");
        }
        return k_differenceSum;
    }

}
