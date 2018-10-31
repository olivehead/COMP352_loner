import java.util.*;

public class ListTester {

    public static void main(String[] args) {
        int[] NValues = new int[] {10, 100, 1000};
        int[] NTiming = new int[NValues.length];

        MyArrayList<Integer> ArrList = new MyArrayList<>();

        //Insert @end test case:
        for (int i=0; i<NValues.length -1; i++) {
            for (int j =0; j<NValues[i]-1; j++) {
                long startTime = System.nanoTime();
                ArrList.add(randomNumberInRange(0, 2*NValues[i]));
                long endTime = System.nanoTime();
                long duration = (endTime - startTime);
                NTiming[i] = (int) duration;
            }
        }

        System.out.println(NTiming);
    }

    public static int randomNumberInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
