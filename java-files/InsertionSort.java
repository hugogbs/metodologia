//Java program for implementation of Insertion Sort
//http://www.geeksforgeeks.org/insertion-sort/
import java.io.*;
import java.util.*;

class InsertionSort {
 private long initialTime;
 private long finalTime;
 private static String inputFile;
 private static String outputFile;

/*Function to sort array using insertion sort*/
 void sort(int arr[]) {
	 initialTime = System.nanoTime();
     int n = arr.length;
     for (int i=1; i<n; ++i) {
         int key = arr[i];
         int j = i-1;

         /* Move elements of arr[0..i-1], that are
            greater than key, to one position ahead
            of their current position */
         while (j>=0 && arr[j] > key)
         {
             arr[j+1] = arr[j];
             j = j-1;
         }
         arr[j+1] = key;
     }
     finalTime = System.nanoTime();
     writeOutput();
 }

 private void writeOutput() {
	long duration = finalTime - initialTime;
	String sortingMethod = "InsertionSort";

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

 // Driver method
 public static void main(String args[]) {        

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

			InsertionSort ob = new InsertionSort();
			ob.sort(input);

	} catch (FileNotFoundException e) {
			System.out.println("Não foi possível encontrar o arquivo <" + inputFile + ">");
			System.exit(1);
	}

 }
} /* This code is contributed by Rajat Mishra. */
