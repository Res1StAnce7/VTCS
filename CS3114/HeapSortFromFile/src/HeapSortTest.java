import student.TestCase;

/**
 * This class tests the HeapSort class.
 * 
 * 
 * @author Siliang Zhang
 * @version 06/22/2022
 */
public class HeapSortTest extends TestCase {

    /**
     * Test for the main.
     */
    public void testMain() {
        String[] args = {"test.dat", "4", "output.txt"};
        HeapSort.main(args);
        String output = systemOut().getHistory();

        //assertEquals(output, "14 2964 8162 27075 16498 6953 24663 2533 \n");
        assertEquals(output, "\n");
    }
}
