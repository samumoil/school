public class TRAI_24_X1_samumoi implements TRAI_24_X1 {

    /**
     * SELF-EVALUATION HERE:
     *
     * I liked this assigment and found it quite easy. Good way to start this course!
     *
     */

    /**
     * Difference between the largest and the smallest element of an integer array.
     *
     * Finds the largest and smallest number in the array, subtract the smallest from the largest,
     * and return the difference as the result.
     * If the array contains only one element, that element is both the largest
     * and smallest, so the result should be 0 (the difference of the number with itself). If the
     * array is empty, return null.
     *
     * You can assume that the array contains only valid integers (i.e., no null values).
     * Do not modify the input array.
     *
     * @param A Input array
     * @return difference of the largest and smallest element, or null if the array is empty.
     */
    @Override
    public Integer maxMinDiff(Integer[] A) {
        if (A.length < 1)
            return null;

        // Array contains at least 1 integer. Make that integer both smallest and largest.
        int smallest = A[0];
        int largest = A[0];

        // Compare rest of the array to smallest and largest, if there is more than one integer in array.
        // Beginning from second integer.
        if (A.length > 1) {
            for (int i = 1; i < A.length; i++) {
                if (A[i] < smallest) {
                    smallest = A[i];
                }
                else if (A[i] > largest) {
                    largest = A[i];
                }
            }
        }

        return largest - smallest;
    }
}