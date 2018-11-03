import java.util.*;

public class ListTester {

    public static <E> void printArray(E[] inputArray) {
        // display array elements
        for (E element : inputArray)
            System.out.printf("%s ", element);

        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] NValues = new Integer[] {10, 100, 1000, 10000, 10000};
        Double[] NTiming = new Double[NValues.length];
        Double[] NTiming2 = new Double[NValues.length];
        Integer[][] RandomNumbersArr = new Integer[NValues.length][];

        long startTime;
        long endTime;
        Double duration;

        MyArrayList<Integer> ArrList = new MyArrayList<>();

        Random random = new Random();

        RandomNumbersArr = GenerateRandArray(NValues);

        //Insert @end test case:
        for (int i=0; i<NValues.length; i++) {
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                ArrList.add(RandomNumbersArr[i][j]);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            NTiming[i] = duration;
        }
        //Insert Randomly:
        for (int i=0; i<NValues.length; i++) {
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                ArrList.add(random.nextInt(ArrList.size() + 1), RandomNumbersArr[i][j]);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            NTiming2[i] = duration;
        }

        //Default ArrayList Class
        ArrayList<Integer> DefArrList = new ArrayList<>(NValues.length);

        //Insert @end test case:
        for (int i=0; i<NValues.length; i++) {
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                ArrList.add(RandomNumbersArr[i][j]);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            NTiming[i] = duration;
        }


        //Print Random Values:
        System.out.println(RandomNumbersArr[1][4] + ", " +RandomNumbersArr[3][24]);
        printArray(NValues);
        printArray(NTiming);
        printArray(NTiming2);

    }

    public static Integer[][] GenerateRandArray(Integer[] NValuesArray) {
        int min = 0;
        Integer[][] RandomIntArray = new Integer[NValuesArray.length][NValuesArray[NValuesArray.length-1]];
        Random random = new Random();

        for (int i =0; i<NValuesArray.length; i++) {
            for (int j=0; j<NValuesArray[i]-1; j++) {
                RandomIntArray[i][j] = random.nextInt((2 * NValuesArray[i] - min) + 1);
            }
        }
        return RandomIntArray;
    }
}
