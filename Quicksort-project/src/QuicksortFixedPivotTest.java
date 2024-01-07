/**
 * A test class for QuicksortFixedPivot.
 *
 * @author Farhan Syed
 * @version 2022-03-01
 */
public class QuicksortFixedPivotTest extends IntSorterTest {

    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortFixedPivot();
    }

}
