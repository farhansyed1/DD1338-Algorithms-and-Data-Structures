 import org.junit.Test;
 import org.junit.Before;

 import java.util.Arrays;

 import static org.junit.Assert.*;

 import static org.hamcrest.MatcherAssert.assertThat;
 import static org.hamcrest.CoreMatchers.*;

 /**
  * Abstract test class for  implementations.
  *
  * Implementing test classes must override the getIntSorter method.
  *
  * @author Simon Larsén
  * @author Farhan Syed
  * @version 2022-03-01
  */
 public abstract class IntSorterTest {

     /* An array of even length */
     private int[] evenArray;
     /* An array of odd length */
     private int[] oddArray;

     /* An array sorted in ascending order */
     private int[] sortedInAscendingOrderArray;
     /* An array sorted in descending order */
     private int[] sortedInDescendingOrderArray;
     /* An array with random elements */
     private int[] randomArray;

     /* An array with all elements equal */
     private int[] allElementsEqualArray;
     /* An array with a very large size */
     private int[] veryLargeArray;

     private IntSorter sortingAlgorithm;

     /**
      * Returns an implementation of the IntSorter interface. Extending classes
      * must override this method.
      *
      * @return An implementation of IntSorter.
      */
     protected abstract IntSorter getIntSorter();

     @Before
     public void setUp() {

         evenArray = new Data(10, 6, Data.Order.RANDOM).get();
         oddArray = new Data(11, 6, Data.Order.RANDOM).get();
         sortedInAscendingOrderArray = new Data(10, 50, Data.Order.ASCENDING).get();
         sortedInDescendingOrderArray = new Data(10, 50, Data.Order.DESCENDING).get();
         randomArray = new Data(10, 50, Data.Order.RANDOM).get();
         allElementsEqualArray = new Data(10, 1, Data.Order.RANDOM).get();
         veryLargeArray = new Data(1000, 500, Data.Order.RANDOM).get();

         sortingAlgorithm = getIntSorter();
     }

     @Test
     public void sortEvenArrayGivesCorrectOrdering() {
         // Arrange
         int[] array = evenArray.clone();
         int[] correctlyOrderedArray = evenArray.clone();

         // Act
         sortingAlgorithm.sort(array);
         Arrays.sort(correctlyOrderedArray);

         // Assert
         assertThat(correctlyOrderedArray, equalTo(array));
     }

     @Test
     public void sortOddArrayGivesCorrectOrdering() {
         // Arrange
         int[] array = oddArray.clone();
         int[] correctlyOrderedArray = oddArray.clone();

         // Act
         sortingAlgorithm.sort(array);
         Arrays.sort(correctlyOrderedArray);

         // Assert
         assertThat(correctlyOrderedArray, equalTo(array));
     }

     @Test
     public void sortHasNoEffectWhenArrayIsSortedInAscendingOrder() {
         // Arrange
         int[] array = sortedInAscendingOrderArray.clone();

         // Act
         sortingAlgorithm.sort(array);

         // Assert
         assertThat(sortedInAscendingOrderArray, equalTo(array));
     }

     @Test
     public void sortArrayInDescendingOrderGivesCorrectOrdering() {
         // Arrange
         int[] array = sortedInDescendingOrderArray.clone();
         int[] correctlyOrderedArray = sortedInDescendingOrderArray.clone();

         // Act
         sortingAlgorithm.sort(array);
         Arrays.sort(correctlyOrderedArray);

         // Assert
         assertThat(correctlyOrderedArray, equalTo(array));
     }

     @Test
     public void sortRandomArrayGivesCorrectOrdering() {
         // Arrange
         int[] array = randomArray.clone();
         int[] correctlyOrderedArray = randomArray.clone();

         // Act
         sortingAlgorithm.sort(array);
         Arrays.sort(correctlyOrderedArray);

         // Assert
         assertThat(correctlyOrderedArray, equalTo(array));
     }

     @Test
     public void sortHasNoEffectWhenAllElementsInArrayAreEqual() {
         // Arrange
         int[] array = allElementsEqualArray.clone();

         // Act
         sortingAlgorithm.sort(array);

         // Assert
         assertThat(allElementsEqualArray, equalTo(array));
     }

     @Test
     public void sortVeryLargeArrayGivesCorrectOrdering() {
         // Arrange
         int[] array = veryLargeArray.clone();
         int[] correctlyOrderedArray = veryLargeArray.clone();

         // Act
         sortingAlgorithm.sort(array);
         Arrays.sort(correctlyOrderedArray);

         // Assert
         assertThat(correctlyOrderedArray, equalTo(array));
     }

 }
