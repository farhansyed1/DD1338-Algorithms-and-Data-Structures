/**
 * A test class for InsertionSort.
 *
 * @author Farhan Syed
 * @version 2022-03-01
 */
public class InsertionSortTest extends IntSorterTest {

    @Override
    protected IntSorter getIntSorter() {
        return new InsertionSort();
    }

}
