// Java program for implementation of Heap Sort
// fonte: http://www.geeksforgeeks.org/heap-sort/

import java.io.*;
import java.util.*;

public class HeapSort
{
  private long initialTime;
  private long finalTime;
  private static String inputFile;
  private static String outputFile;

  
    public void sort(int arr[])
    {
      initialTime = System.nanoTime();
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }

      finalTime = System.nanoTime();
      writeOutput();
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }


         private void writeOutput() {
        	long duration = finalTime - initialTime;
        	String sortingMethod = "HeapSort";

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


    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
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

         HeapSort ob = new HeapSort();
         ob.sort(input);

     } catch (FileNotFoundException e) {
         System.out.println("Não foi possível encontrar o arquivo <" + inputFile + ">");
         System.exit(1);
     }

    }
}
