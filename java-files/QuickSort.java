// Java program for implementation of QuickSort
// http://www.geeksforgeeks.org/quick-sort/
import java.io.*;
import java.util.*;

public class QuickSort {
     private static long initialTime;
	 private static long finalTime;
	 private static String inputFile;
	 private static String outputFile;
	private int array[];
    private int length;
 
    public void sort(int[] inputArr) {
        
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }
 
    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which 
             * is greater then the pivot value, and also we will identify a number 
             * from right side which is less then the pivot value. Once the search 
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    private static void writeOutput() {
		long duration = finalTime - initialTime;
		String sortingMethod = "QuickSort";

		try {
			FileWriter fw = new FileWriter(outputFile, true);

			fw.append(sortingMethod);
			fw.append(",");
			fw.append(inputFile);
			fw.append(",");
			fw.append(String.valueOf(duration));
			fw.append("\n");

			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	 }
     
    public static void main(String args[]){
		
		 inputFile = args[0];
		 outputFile = args[1];

		 try {
				Scanner s = new Scanner(new File(inputFile));
				int[] input = new int[s.nextInt()];

				for (int i = 0; i < input.length; i++) {
					if (s.hasNextInt()) {
						input[i] = s.nextInt();
					}
				}

				s.close();

				QuickSort sorter = new QuickSort();
			
				initialTime = System.nanoTime();
				sorter.sort(input);
				finalTime = System.nanoTime();
				writeOutput();

		} catch (FileNotFoundException e) {
				System.out.println("Não foi possível encontrar o arquivo <" + inputFile + ">");
				System.exit(1);
		}
			 
			
		}
}
