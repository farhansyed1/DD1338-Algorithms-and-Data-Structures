/**
 * A test class for QuicksortRandomPivotInsertion.
 *
 * @author Farhan Syed
 * @version 2022-03-01
 */
public class QuicksortRandomPivotInsertionTest extends IntSorterTest{

    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortRandomPivotInsertion();
    }
}
