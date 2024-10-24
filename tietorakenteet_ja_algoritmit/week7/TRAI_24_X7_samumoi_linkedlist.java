import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class TRAI_24_X7_samumoi_linkedlist<E> implements TRAI_24_X7<E> {

    private AnchorNode<E> lista;
    private int globalModCount;
    private int queueSize;


    public TRAI_24_X7_samumoi_linkedlist() {
        lista = new AnchorNode<>();
        globalModCount = 0;
        queueSize = 0;
    }

    private class AnchorNode<E> {
        private Node<E> headNode;
        private Node<E> tailNode;

        public <E> AnchorNode() {
        }

        public Node<E> getHeadNode() {
            return headNode;
        }

        public <E> void addTailNode(E x) {
            if (headNode == null) {
                headNode = new Node(x);
                tailNode = headNode;
            } else {
                tailNode.setSuccNode(new Node(x));
                tailNode = tailNode.getSuccNode();
            }
        }

        public E delHeadNode() {
            E payload = headNode.getAndClearPayload();
            headNode = headNode.getAndClearSuccNode();
            return payload;
        }
    }

    private class Node<E> {
        private Node<E> succNode;
        private E payload;

        public Node(E x){
            payload = x;
        }

        public void setSuccNode(Node<E> succNode) {
            this.succNode = succNode;
        }

        public Node getSuccNode() {
            return succNode;
        }

        public E getPayload() {
            return payload;
        }

        public Node getAndClearSuccNode() {
            Node<E> returnSuccNode = succNode;
            succNode = null;
            return returnSuccNode;
        }

        public E getAndClearPayload() {
            E returnPayload = payload;
            payload = null;
            return returnPayload;
        }
    }

    /**
     * Adds an element to tail of the queue.
     *
     * @param x element to add
     * @return true
     */
    @Override
    public boolean add(E x) {
        lista.addTailNode(x);
        queueSize++;
        globalModCount++;
        return true;
    }

    /**
     * Removes and returns the head of the queue
     *
     * @return element that was removed
     * @throws NoSuchElementException if queue was empty
     */
    @Override
    public E remove() {
        if (lista.getHeadNode() == null) {
            throw new NoSuchElementException();
        }
        E returnElement = lista.delHeadNode();
        queueSize--;
        globalModCount++;
        return returnElement;
    }

    /**
     * Is queue empty or not?
     *
     * @return true if queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return (queueSize == 0);
    }


    @Override
    public String toString() {
        StringBuilder merkkijono = new StringBuilder("[");
        Node<E> noodi = lista.getHeadNode();
        for (int i=0; i<queueSize; i++) {
            merkkijono.append(noodi.getPayload().toString() + ", ");
            noodi = noodi.getSuccNode();
        }
        merkkijono.delete(merkkijono.length()-2, merkkijono.length());
        merkkijono.append("]");
        return merkkijono.toString();
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

        private Node<E> noodi;
        private int modCount;

        public Iterator() {
            noodi = (Node<E>) lista.getHeadNode();
            modCount = globalModCount;
        }

        @Override
        public boolean hasNext() {
            if (modCount != globalModCount) {
                throw new ConcurrentModificationException();
            }
            return (noodi != null);
        }

        @Override
        public E next() {
            if (modCount != globalModCount) {
                throw new ConcurrentModificationException();
            }
            if (noodi == null) {
                throw new NoSuchElementException();
            }
            E returnE = noodi.getPayload();
            noodi = noodi.getSuccNode();
            return returnE;
        }
    }


}
