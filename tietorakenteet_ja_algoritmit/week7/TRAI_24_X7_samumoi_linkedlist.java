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

    public TRAI_24_X7_samumoi_linkedlist(E x) {
        lista = new AnchorNode<>(x);
        globalModCount = 0;
        queueSize = 1;
    }

    private class Node<E> {
        private Node<E> succNode;
        private E payload;

        public Node(E x){
            payload = x;
        }

        public void setSuccNode(Node<E> succNode) {
            succNode = succNode;
        }

        public Node getSuccNode() {
            return succNode;
        }

        public Node getAndClearSuccNode() {
            Node<E> returnSuccNode = succNode;
            succNode = null;
            return returnSuccNode;
        }

        public E getPayload() {
            return payload;
        }

        public <E> E getAndClearPayload() {
            E returnPayload = payload;
            payload = null;
            return returnPayload;
        }
    }

    private class AnchorNode<E> {
        public Node<E> headNode;
        public Node<E> tailNode;

        public <E> AnchorNode() {
        }

        public <E> AnchorNode(E x) {
            headNode = new Node(x);
            tailNode = headNode;
        }

        public <E> void setHeadNode(E x) {
            headNode = new Node(x);
        }

        public Node<E> getHeadNode() {
            return headNode;
        }

        public E delHeadNode() {
            E payload = headNode.getAndClearPayload();
            headNode = headNode.getAndClearSuccNode();
            return payload;
        }

        public <E> void setTailNode(E x) {
            tailNode.setSuccNode(new Node(x));
            tailNode = tailNode.getSuccNode();
            queueSize++;
        }

        public Node<E> getTailNode() {
            return tailNode;
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
        if (lista.getHeadNode() == null) {
            lista.setHeadNode(new Node(x));
            lista.setTailNode(lista.getHeadNode());
        } else {
            lista.getTailNode().setSuccNode(new Node(x));
            lista.setTailNode(lista.getTailNode().getSuccNode());
        }
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
        return null;
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
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }


}
