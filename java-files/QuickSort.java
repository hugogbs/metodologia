// Java program for implementation of QuickSort
// http://www.geeksforgeeks.org/quick-sort/
import java.io.*;
import java.util.*;

class QuickSort
{
  private long initialTime;
  private long finalTime;
  private static String inputFile;
  private static String outputFile;

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high)
    {
      initialTime = System.nanoTime();

        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }

        finalTime = System.nanoTime();
        writeOutput();
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
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


    // Driver program
    public static void main(String args[])
    {
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

        QuickSort ob = new QuickSort();
        ob.sort(input, 0, input.length);

      } catch (FileNotFoundException e) {
          System.out.println("Não foi possível encontrar o arquivo <" + inputFile + ">");
          System.exit(1);
      }
    }
}
/*This code is contributed by Rajat Mishra */
