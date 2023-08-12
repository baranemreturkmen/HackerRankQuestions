import java.util.ArrayList;
import java.util.List;

public class DoubleOnMatch {

    public static void main(String[] args) {

        List<Long> arr = new ArrayList<>();
        arr.add(1L);
        arr.add(2L);
        arr.add(4L);
        arr.add(11L);
        arr.add(12L);
        arr.add(8L);

        List<Long> arr2 = new ArrayList<>();
        arr2.add(1L);
        arr2.add(2L);
        arr2.add(3L);
        arr2.add(2L);
        arr2.add(1L);

        List<Long> arr3 = new ArrayList<>();
        arr3.add(1L);
        arr3.add(1L);
        arr3.add(1L);

        List<Long> arr4 = new ArrayList<>();
        arr4.add(2L);
        arr4.add(3L);
        arr4.add(-2L);
        arr4.add(7L);
        arr4.add(4L);
        arr4.add(-9L);
        arr4.add(10L);
        arr4.add(8L);
        arr4.add(-12L);
        arr4.add(70L);
        arr4.add(16L);

        System.out.println(doubleSize(arr,2));
        System.out.println(doubleSize(arr2,1));
        System.out.println(doubleSize(arr3,1));
        System.out.println(doubleSize(arr4,2));
    }

    public static long doubleSize(List<Long> arr, long b){

        for (var variable: arr) {
            if(variable==b){
                b*=2;
            }
        }
        return b;
    }

}
