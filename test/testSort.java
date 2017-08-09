import org.junit.Before;
import org.junit.Test;
import org.junit.Assert.assertArrayEquals;

public class testSort {
  private final int[] asc_array = {-2, -4, 0, 3, 7, 10, 22, 40};
  private final int[] desc_array = {40, 22, 10, 7, 3, 0, -4, -2};
  private final int[] sfl_array = {10, 40, -4, 7, -2, 3, 0, 22};
  private final int[] emp_array = {};

  private final int[] expec_array = {-2, -4, 0, 3, 7, 10, 22, 40};

  private int[] asc = new int[10];
  private int[] desc = new int[10];
  private int[] sfl = new int[10];
  private int[] emp = {};


  @Before
  public void setUp(){
    asc = java.util.Arrays.copyOfRange(asc_array, 0, 8);
    desc = java.util.Arrays.copyOfRange(desc_array, 0, 8);
    sfl = java.util.Arrays.copyOfRange(sfl_array, 0, 8);
  }

  @Test
  public void testQuickSort(){
    QuickSort quick = new QuickSort();
    quick.sort(asc);
    quick.sort(desc);
    quick.sort(sfl);
    quick.sort(emp);

    assertArrayEquals(expec_array, asc);
    assertArrayEquals(expec_array, desc);
    assertArrayEquals(expec_array, sfl);
    assertArrayEquals(emp_array, emp);
  }

  @Test
  public void testHeapSort(){
    HeapSort heap = new HeapSort();
    heap.sort(asc);
    heap.sort(desc);
    heap.sort(sfl);
    heap.sort(emp);

    assertArrayEquals(expec_array, asc);
    assertArrayEquals(expec_array, desc);
    assertArrayEquals(expec_array, sfl);
    assertArrayEquals(emp_array, emp);
  }


    @Test
    public void testQuick3WaySort(){
      Quick3way quick3 = new Quick3way();
      quick3.sort(asc);
      quick3.sort(desc);
      quick3.sort(sfl);
      quick3.sort(emp);

      assertArrayEquals(expec_array, asc);
      assertArrayEquals(expec_array, desc);
      assertArrayEquals(expec_array, sfl);
      assertArrayEquals(emp_array, emp);
    }

      @Test
      public void testCountingSort(){
        CountingSort count = new CountingSort();
        count.sort(asc);
        count.sort(desc);
        count.sort(sfl);
        count.sort(emp);

        assertArrayEquals(expec_array, asc);
        assertArrayEquals(expec_array, desc);
        assertArrayEquals(expec_array, sfl);
        assertArrayEquals(emp_array, emp);
      }

      @Test
      public void testInsertionSort(){
        InsertionSort ins = new InsertionSort();
        ins.sort(asc);
        ins.sort(desc);
        ins.sort(sfl);
        ins.sort(emp);

        assertArrayEquals(expec_array, asc);
        assertArrayEquals(expec_array, desc);
        assertArrayEquals(expec_array, sfl);
        assertArrayEquals(emp_array, emp);
      }
}
