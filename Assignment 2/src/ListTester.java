import java.text.DecimalFormat;
import java.util.*;

public class ListTester {

    public static <E> void printArray(E[] inputArray) {
        // display array elements
        for (E element : inputArray)
            System.out.printf("%s", element + "\t");

        System.out.println();
    }

    public static void main(String[] args) {
        //Input Values:
        Integer[] NValues = new Integer[] {10, 100, 1000, 10000, 10000};
        Integer[][] RandomNumbersArr;
        Random random = new Random();
        RandomNumbersArr = GenerateRandArray(NValues);

        //Array:
        MyArrayList<Integer> ArrList = new MyArrayList<>();
        ArrayList<Integer> DefArrList = new ArrayList<>();
        //LinkedList:
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        LinkedList<Integer> DefLinkedList = new LinkedList<>();

        //Timing Output:
        Double[][] InsertStartTime = new Double[4][NValues.length];
        Double[][] InsertEndTime = new Double[4][NValues.length];
        Double[][] InsertRandomTime= new Double[4][NValues.length];
        Double[][] RemoveStartTime = new Double[4][NValues.length];
        Double[][] RemoveEndTime = new Double[4][NValues.length];
        Double[][] RemoveRandomTime = new Double[4][NValues.length];
        Double[][] RemoveValueTime = new Double[4][NValues.length];

        //Format Output:
        DecimalFormat formatNum = new DecimalFormat("0.000");

        //Time measurement
        long startTime;
        long endTime;
        Double duration;

        //Insert @end:
        //MyArrayList
        for (int i=0; i<NValues.length; i++) {
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                ArrList.add(RandomNumbersArr[i][j]);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            InsertEndTime[0][i] = duration;
            ArrList.clear();
        }
        //Java Default ArrayList:
        for (int i=0; i<NValues.length; i++) {
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                DefArrList.add(RandomNumbersArr[i][j]);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            InsertEndTime[1][i] = duration;
            DefArrList.clear();
        }

        //MyLinkedList:
        for (int i=0; i<NValues.length; i++) {
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                myLinkedList.add(RandomNumbersArr[i][j]);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            InsertEndTime[2][i] = duration;
            myLinkedList.clear();
        }

        //Java LinkedList:
        for (int i=0; i<NValues.length; i++) {
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                DefLinkedList.add(RandomNumbersArr[i][j]);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            InsertEndTime[3][i] = duration;
            DefLinkedList.clear();
        }

        //Insert @beginning:
        //MyArrayList
        for (int i=0; i<NValues.length; i++) {
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                ArrList.add(0, RandomNumbersArr[i][j]);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            InsertStartTime[0][i] = duration;
            ArrList.clear();
        }

        //Java Default ArrayList:
        for (int i=0; i<NValues.length; i++) {
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                DefArrList.add(0, RandomNumbersArr[i][j]);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            InsertStartTime[1][i] = duration;
            DefArrList.clear();
        }

        //MyLinkedList:
        for (int i=0; i<NValues.length; i++) {
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                myLinkedList.add(0, RandomNumbersArr[i][j]);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            InsertEndTime[2][i] = duration;
            myLinkedList.clear();
        }

        //Java LinkedList:
        for (int i=0; i<NValues.length; i++) {
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                DefLinkedList.add(0, RandomNumbersArr[i][j]);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            InsertEndTime[3][i] = duration;
            DefLinkedList.clear();
        }

        //Insert Randomly:
        //MyArrayList
        for (int i=0; i<NValues.length; i++) {
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                ArrList.add(random.nextInt(ArrList.size() + 1), RandomNumbersArr[i][j]);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            InsertRandomTime[0][i] = duration;
            ArrList.clear();
        }

        //Java Default ArrayList:
        for (int i=0; i<NValues.length; i++) {
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                DefArrList.add(random.nextInt(DefArrList.size() + 1), RandomNumbersArr[i][j]);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            InsertRandomTime[1][i] = duration;
            DefArrList.clear();
        }

        //MyLinkedList:
        for (int i=0; i<NValues.length; i++) {
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                myLinkedList.add(random.nextInt(myLinkedList.size() + 1), RandomNumbersArr[i][j]);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            InsertEndTime[2][i] = duration;
            myLinkedList.clear();
        }

        //Java LinkedList:
        for (int i=0; i<NValues.length; i++) {
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                DefLinkedList.add(random.nextInt(DefLinkedList.size() + 1), RandomNumbersArr[i][j]);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            InsertEndTime[3][i] = duration;
            DefLinkedList.clear();
        }

        //Remove @Start
        //MyArrayList
        for (int i=0; i<NValues.length; i++) {
            for (int j =0; j<NValues[i]-1; j++) {
                ArrList.add(RandomNumbersArr[i][j]);
            }
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                ArrList.remove(0);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            RemoveStartTime[0][i] = duration;
        }

        //Default
        for (int i=0; i<NValues.length; i++) {
            for (int j =0; j<NValues[i]-1; j++) {
                DefArrList.add(RandomNumbersArr[i][j]);
            }
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                DefArrList.remove(0);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            RemoveStartTime[1][i] = duration;
        }

        //MyLinkedList
        for (int i=0; i<NValues.length; i++) {
            for (int j =0; j<NValues[i]-1; j++) {
                myLinkedList.add(RandomNumbersArr[i][j]);
            }
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                myLinkedList.remove(0);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            RemoveStartTime[2][i] = duration;
        }

        //Default LinkedList
        for (int i=0; i<NValues.length; i++) {
            for (int j =0; j<NValues[i]-1; j++) {
                DefLinkedList.add(RandomNumbersArr[i][j]);
            }
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                DefLinkedList.remove(0);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            RemoveStartTime[3][i] = duration;
        }

        //Remove @end
        //MyArrayList
        for (int i=0; i<NValues.length; i++) {
            for (int j =0; j<NValues[i]-1; j++) {
                ArrList.add(RandomNumbersArr[i][j]);
            }
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                ArrList.remove(ArrList.size()-1);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            RemoveEndTime[0][i] = duration;
        }

        //Default
        for (int i=0; i<NValues.length; i++) {
            for (int j =0; j<NValues[i]-1; j++) {
                DefArrList.add(RandomNumbersArr[i][j]);
            }
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                DefArrList.remove(DefArrList.size()-1);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            RemoveEndTime[1][i] = duration;
        }

        //MyLinkedList
        for (int i=0; i<NValues.length; i++) {
            for (int j =0; j<NValues[i]-1; j++) {
                myLinkedList.add(RandomNumbersArr[i][j]);
            }
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                myLinkedList.remove(myLinkedList.size()-1);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            RemoveStartTime[2][i] = duration;
        }

        //Default LinkedList
        for (int i=0; i<NValues.length; i++) {
            for (int j =0; j<NValues[i]-1; j++) {
                DefLinkedList.add(RandomNumbersArr[i][j]);
            }
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                DefLinkedList.remove(DefLinkedList.size()-1);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            RemoveStartTime[3][i] = duration;
        }

        //Remove @random
        //MyArrayList
        for (int i=0; i<NValues.length; i++) {
            for (int j =0; j<NValues[i]-1; j++) {
                ArrList.add(RandomNumbersArr[i][j]);
            }
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                ArrList.remove((int) RandomNumbersArr[i][random.nextInt(ArrList.size() + 1)]);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            RemoveRandomTime[0][i] = duration;
            ArrList.clear();
        }

        //Default
        for (int i=0; i<NValues.length; i++) {
            for (int j =0; j<NValues[i]-1; j++) {
                DefArrList.add(RandomNumbersArr[i][j]);
            }
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                DefArrList.remove((int) RandomNumbersArr[i][random.nextInt(ArrList.size() + 1)]);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            RemoveRandomTime[1][i] = duration;
            ArrList.clear();
        }

        //MyLinkedList
        for (int i=0; i<NValues.length; i++) {
            for (int j =0; j<NValues[i]-1; j++) {
                myLinkedList.add(RandomNumbersArr[i][j]);
            }
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                myLinkedList.remove((int) RandomNumbersArr[i][random.nextInt(myLinkedList.size() + 1)]);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            RemoveStartTime[2][i] = duration;
        }

        //Default LinkedList
        for (int i=0; i<NValues.length; i++) {
            for (int j =0; j<NValues[i]-1; j++) {
                DefLinkedList.add(RandomNumbersArr[i][j]);
            }
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                DefLinkedList.remove((int) RandomNumbersArr[i][random.nextInt(DefLinkedList.size() + 1)]);
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            RemoveStartTime[3][i] = duration;
        }

        //Remove by value
        //MyArrayList
        for (int i=0; i<NValues.length; i++) {
            for (int j =0; j<NValues[i]-1; j++) {
                ArrList.add(RandomNumbersArr[i][j]);
            }
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                ArrList.remove((Integer) random.nextInt(2 * NValues[i]+ 1));
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            RemoveValueTime[0][i] = duration;
        }

        //Default
        for (int i=0; i<NValues.length; i++) {
            for (int j =0; j<NValues[i]-1; j++) {
                DefArrList.add(RandomNumbersArr[i][j]);
            }
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                DefArrList.remove((Integer) random.nextInt(2 * NValues[i]+ 1));
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            RemoveValueTime[1][i] = duration;
        }

        //MyLinkedList
        for (int i=0; i<NValues.length; i++) {
            for (int j =0; j<NValues[i]-1; j++) {
                myLinkedList.add(RandomNumbersArr[i][j]);
            }
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                myLinkedList.remove((Integer) random.nextInt(2 * NValues[i]+ 1));
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            RemoveStartTime[2][i] = duration;
        }

        //Default LinkedList
        for (int i=0; i<NValues.length; i++) {
            for (int j =0; j<NValues[i]-1; j++) {
                DefLinkedList.add(RandomNumbersArr[i][j]);
            }
            startTime = System.nanoTime();
            for (int j =0; j<NValues[i]-1; j++) {
                DefLinkedList.remove((Integer) random.nextInt(2 * NValues[i]+ 1));
            }
            endTime = System.nanoTime();
            duration = (endTime - startTime)/(double) 1000000;
            RemoveStartTime[3][i] = duration;
        }

        //Print Results:
        System.out.println("Insert at Start Timing (ms):");
        printArray(NValues);
        for (int i=0; i<4;i++) {
            for (int j=0; j<NValues.length; j++) {
                System.out.print(formatNum.format(InsertStartTime[i][j]) + "\t");
            }
            System.out.println();
        }

        System.out.println("Insert at End Timing (ms):");
        printArray(NValues);
        for (int i=0; i<4;i++) {
            for (int j=0; j<NValues.length; j++) {
                System.out.print(formatNum.format(InsertEndTime[i][j]) + "\t");
            }
            System.out.println();
        }
        System.out.println("Insert at Random Timing (ms):");
        printArray(NValues);
        for (int i=0; i<4;i++) {
            for (int j=0; j<NValues.length; j++) {
                System.out.print(formatNum.format(InsertRandomTime[i][j]) + "\t");
            }
            System.out.println();
        }
        System.out.println("Remove at Start Timing (ms):");
        printArray(NValues);
        for (int i=0; i<4;i++) {
            for (int j=0; j<NValues.length; j++) {
                System.out.print(formatNum.format(RemoveStartTime[i][j]) + "\t");
            }
            System.out.println();
        }
        System.out.println("Remove at End Timing (ms):");
        printArray(NValues);
        for (int i=0; i<4;i++) {
            for (int j=0; j<NValues.length; j++) {
                System.out.print(formatNum.format(RemoveEndTime[i][j]) + "\t");
            }
            System.out.println();
        }
        System.out.println("Remove at Random Timing (ms):");
        printArray(NValues);
        for (int i=0; i<4;i++) {
            for (int j=0; j<NValues.length; j++) {
                System.out.print(formatNum.format(RemoveRandomTime[i][j]) + "\t");
            }
            System.out.println();
        }
        System.out.println("Remove at Value Timing (ms):");
        printArray(NValues);
        for (int i=0; i<4;i++) {
            for (int j=0; j<NValues.length; j++) {
                System.out.print(formatNum.format(RemoveValueTime[i][j]) + "\t");
            }
            System.out.println();
        }
    }

    //Generates random numbers for all test cases
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
