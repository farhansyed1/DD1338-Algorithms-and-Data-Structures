import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 * Test class for LinkedList
 *
 *
 * @author Farhan Syed
 * @version 2022-02-01
 */
public class LinkedListTest extends StackTest {

    /* A sequence of integers */
    private int[] elements;

    /* An empty linked list */
    private LinkedList<Integer> list;

    @Before
    public void setUp() {
        super.setUp();
        list = new LinkedList<Integer>();
        elements = new int[]{-919,  388,   67, -248, -309, -725,  904,   53,
                90, -469, -559,  256,  612,  366, -412, -221,
                347, -921, -978,  324, -858,  480, -443,  891,
                329,   -5,  878, -538,  445, -366,  760,   52};
    }

    @Override
    protected Stack<Integer> getIntegerStack() {
        return new LinkedList<Integer>();
    }

}