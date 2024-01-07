/**
 * A test class for QuicksortFixedPivotInsertion.
 *
 * @author Farhan Syed
 * @version 2022-03-01
 */
public class QuicksortFixedPivotInsertionTest extends IntSorterTest {

    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortFixedPivotInsertion();
    }

}
