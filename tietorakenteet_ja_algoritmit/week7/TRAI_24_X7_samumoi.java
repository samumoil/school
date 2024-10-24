import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TRAI_24_X7_samumoi<E> implements TRAI_24_X7<E> {

    /**
     * SELF-EVALUATION HERE:
     *
     * I think this assignment's difficulty was right on point. We are at the end of course and trying to implement
     * our own versions of these methods and classes is appropriate. It provided good challenge.
     *
     */


    private E[] lista;
    private int globalModCount;
    private int queueSize;
    private int headPosition;
    private int tailPosition;
    // Time complexity for all five above = O(5) = O(1)


    public TRAI_24_X7_samumoi() {
        lista = (E[]) new Object[16];
        globalModCount = 0;
        queueSize = 0;
        headPosition = 0;
        tailPosition = 0;
    } // Time complexity for this function is O(5) = O(1)

    /**
     * Adds an element to tail of the queue.
     *
     * @param x element to add
     * @return true
     */
    @Override
    public boolean add(E x) {
        // Check if list is big enough, double capacity if needed.
        if (queueSize == lista.length) {
            E[] tempLista = (E[]) new Object[lista.length*2];
            for (int i=0; i<queueSize; i++) {
                tempLista[i] = this.remove();
                // Calling remove above reduces queueSize, we have to counter it.
                queueSize++;
            } // Time complexity of this loop is n*(remove(O(8)) + O(1)) -> O(n)
            lista = tempLista;
            headPosition = 0;
            tailPosition = queueSize;
        } // This function is time complexity O(log n) because for-loop doubles the size and is called only rarely.

        lista[tailPosition] = x;
        tailPosition++;
        // Loop back to beginning if at end of list.
        if (tailPosition >= lista.length) {
            tailPosition = 0;
        }
        queueSize++;
        globalModCount++;
        return true;
    } // Rest of this method is O(1) and thus this method as a whole is O(log n)

    /**
     * Removes and returns the head of the queue
     *
     * @return element that was removed
     * @throws NoSuchElementException if queue was empty
     */
    @Override
    public E remove() {
        if (queueSize == 0) {
            throw new NoSuchElementException();
            // Time complexity O(1)
        }
        E removed = lista[headPosition];
        headPosition++;
        // Loop back to beginning if at end of list.
        if (headPosition >= lista.length) {
            headPosition = 0;
        }
        queueSize--;
        globalModCount++;
        return removed;

    } // Time complexity max O(8) -> O(1)

    /**
     * Is queue empty or not?
     *
     * @return true if queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return (queueSize == 0);
    } // Time complexity O(1)


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        int reader = headPosition;
        if (queueSize > 0) {
            while (reader != tailPosition) {
                stringBuilder.append(lista[reader].toString() + ", ");
                reader++;
                if (reader >= lista.length) {
                    reader = 0;
                }
            }
            stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length());
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * This is for task 32.
     * But keep this when submitting task X7
     * It is not tested in X7.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<>();
    }

    private class Iterator<E> implements java.util.Iterator<E> {

        private int reader;
        private int modCount;

        public Iterator() {
            reader = headPosition;
            modCount = globalModCount;
        }

        @Override
        public boolean hasNext() {
            if (modCount != globalModCount) {
                throw new ConcurrentModificationException();
            }
            return reader!=tailPosition;
        }

        @Override
        public E next() {
            if (modCount != globalModCount) {
                throw new ConcurrentModificationException();
            }
            if (reader != tailPosition) {
                E toReturn = (E) lista[reader];
                reader++;
                if (reader >= lista.length) {
                    reader = 0;
                }
                return toReturn;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

}
