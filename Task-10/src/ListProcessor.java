import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Creates methods with different functions using arrays and lists
 * @author Farhan Syed
 * @version 2021-11-24
 */
public class ListProcessor {

    public static void main(String[] args) {
        ListProcessor processor = new ListProcessor();
        System.out.println("Exercise 1 - populating");
        System.out.println("Array: " + Arrays.toString(processor.arraySequence(-5,6)));
        System.out.println("List: " + processor.listSequence(-5,6));

        System.out.println("\n"+ "Exercise 2 - shuffling");
        int[] arrayOfNumbers = {0,-1,2,-3,4,-5,6};
        System.out.println("Original array: " + Arrays.toString(arrayOfNumbers));
        System.out.println("Shuffled array: " + Arrays.toString(processor.shuffled(arrayOfNumbers)));

        List<Integer> listOfNumbers = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            listOfNumbers.add(i);
        }
        System.out.println("Original list: " + listOfNumbers);
        System.out.println("Shuffled list: " + processor.shuffled(listOfNumbers));

        System.out.println("\n"+ "Exercise 3 - summing iteratively");
        System.out.println("Array iterative sum: " + processor.sumIterative(arrayOfNumbers));
        System.out.println("List iterative sum: " + processor.sumIterative(listOfNumbers));

        System.out.println("\n"+ "Exercise 4 - summing recursively");
        System.out.println("Array recursive sum: " + processor.sumRecursive(arrayOfNumbers));
        System.out.println("List recursive sum: " + processor.sumRecursive(listOfNumbers));
    }

    //Exercise 1: Populating
    /**
     * Creates an array containing values between two boundaries
     * @param from  first value in the array (inclusive)
     * @param to    last value in the array (exclusive)
     * @return      the array sequence
     */
    public int[] arraySequence(int from, int to){
        if(to < from){
            throw new IllegalArgumentException("Invalid range");
        }
        int[] sequence = new int[to-from];
        int index = 0;
        for(int i = from; i < to; i++){
            sequence[index] = i;
            index++;
        }
        return sequence;
    }

    /**
     * Creates a list containing values between two boundaries
     * @param from  first value in the list
     * @param to    last value in the list
     * @return      the list sequence
     */
    public List<Integer> listSequence(int from, int to){
        if(to < from){
            throw new IllegalArgumentException("Invalid range");
        }
        List<Integer> sequence = new ArrayList<Integer>();
        for (int i = from; i < to; i++) {
            sequence.add(i);
        }
        return sequence;
    }

    //Exercise 2: Shuffling
    /**
     * Shuffles the values in an array
     * @param numbers   the array containing integers
     * @return          a shuffled array
     */
    public int[] shuffled(int[] numbers){
        Random random = new Random();
        int[] numbersCopy = numbers.clone();
        for (int i = 0; i < numbersCopy.length; i++) {
            int randomIndex = random.nextInt(numbersCopy.length);       //choosing a random index that will switch values with the current index, numbersCopy[i]
            int temp = numbersCopy[randomIndex];                        //storing the value of the random index
            numbersCopy[randomIndex] = numbersCopy[i];                  //giving the random index the value of the current index
            numbersCopy[i] = temp;                                      //giving the current index the previous value of the random index
        }

        return numbersCopy;
    }

    /**
     * Shuffles the values in a list
     * @param numbers    the list containing integers
     * @return           a shuffled list
     */
    public List<Integer> shuffled(List<Integer> numbers){
        Random random = new Random();
        List<Integer> numbersCopy = new ArrayList<>(numbers);
        for (int i = 0; i < numbersCopy.size() ; i++) {
            int randomIndex = random.nextInt(numbersCopy.size());        //choosing a random index that will switch values with the current index, numbersCopy[i]
            int temp = numbersCopy.get(randomIndex);                     //storing the value of the random index
            numbersCopy.set(randomIndex, numbersCopy.get(i));            //giving the random index the value of the current index
            numbersCopy.set(i, temp);                                    //giving the current index the previous value of the random index
        }

        return numbersCopy;
    }

    //Exercise 3 - finding sum iteratively
    /**
     * Calculates the sum of values in an array iteratively
     * @param numbers      an array of integers
     * @return             the sum of the integers in the array
     */
    public int sumIterative(int[] numbers){
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum;
    }

    /**
     * Calculates the sum of values in a list iteratively
     * @param numbers       a list of integers
     * @return              the sum of the integers in the list
     */
    public int sumIterative(List<Integer> numbers){
        int sum = 0;
        for (int i = 0; i < numbers.size() ; i++) {
            sum += numbers.get(i);
        }

        return sum;
    }

    //Exercise 4 - finding sum recursively
    /**
     * Calculates the sum of values in an array recursively
     * @param numbers  an array of integers
     * @return         the sum of the integers in the array
     */
    public int sumRecursive(int[] numbers){
        int lastIndexInArray = numbers.length - 1;
        if(numbers.length == 0){
            return 0;
        }
        int[] numbersExceptLastIndex = Arrays.copyOf(numbers, numbers.length - 1);

        return numbers[lastIndexInArray] + sumRecursive(numbersExceptLastIndex);
    }

    /**
     * Calculates the sum of values in a list recursively
     * @param numbers  a list of integers
     * @return         the sum of the integers in the list
     */
    public int sumRecursive(List<Integer> numbers){
        int lastIndexInList = numbers.size() - 1;
        if(numbers.size() == 0){
            return 0;
        }
        List<Integer> numbersExceptLastIndex = new ArrayList<>(numbers);
        numbersExceptLastIndex.remove(numbers.size()-1);

        return numbers.get(lastIndexInList) + sumRecursive(numbersExceptLastIndex);
    }

}
