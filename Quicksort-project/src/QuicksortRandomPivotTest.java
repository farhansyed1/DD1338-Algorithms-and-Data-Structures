/**
 * A test class for QuicksortRandomPivot.
 *
 * @author Farhan Syed
 * @version 2022-03-01
 */
public class QuicksortRandomPivotTest extends IntSorterTest{

    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortRandomPivot();
    }
}
