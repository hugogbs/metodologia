// Java implementation of Counting Sort
// http://www.geeksforgeeks.org/counting-sort/
import java.io.*;
import java.util.*;

class CountingSort
{
  private long initialTime;
  private long finalTime;
  private static String inputFile;
  private static String outputFile;

    void sort(char arr[])
    {
      initialTime = System.nanoTime();

        int n = arr.length;

        // The output character array that will have sorted arr
        char output[] = new char[n];

        // Create a count array to store count of inidividul
        // characters and initialize count array as 0
        int count[] = new int[256];
        for (int i=0; i<256; ++i)
            count[i] = 0;

        // store count of each character
        for (int i=0; i<n; ++i)
            ++count[arr[i]];

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i=1; i<=255; ++i)
            count[i] += count[i-1];

        // Build the output character array
        for (int i = 0; i<n; ++i)
        {
            output[count[arr[i]]-1] = arr[i];
            --count[arr[i]];
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i<n; ++i)
            arr[i] = output[i];


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

         CountingSort ob = new CountingSort();
         ob.sort(input);

     } catch (FileNotFoundException e) {
         System.out.println("Não foi possível encontrar o arquivo <" + inputFile + ">");
         System.exit(1);
     }

    }
}
/*This code is contributed by Rajat Mishra */
