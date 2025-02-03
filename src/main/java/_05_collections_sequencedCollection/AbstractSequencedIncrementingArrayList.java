package _05_collections_sequencedCollection;


import java.util.SequencedCollection;

public abstract class AbstractSequencedIncrementingArrayList<E> extends AbstractIncrementingArrayList<E> {
    /**
     * Adds an element as the first element of this collection (optional operation).
     * After this operation completes normally, the given element will be a member of
     * this collection, and it will be the first element in encounter order.
     *
     * @param e the element to be added
     * @throws NullPointerException          if the specified element is null and this
     *                                       collection does not permit null elements
     */
    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * Adds an element as the last element of this collection (optional operation).
     * After this operation completes normally, the given element will be a member of
     * this collection, and it will be the last element in encounter order.
     *
     * @param e the element to be added.
     * @throws NullPointerException          if the specified element is null and this
     *                                       collection does not permit null elements
     */
    @Override
    public void addLast(E e) {
        add(size(), e);
    }

    /**
     * Gets the first element of this collection.
     *
     * @return the retrieved element
     * @throws IndexOutOfBoundsException if this collection is empty
     */
    @Override
    public E getFirst() {
        return get(0);
    }

    /**
     * Gets the last element of this collection.
     *
     * @return the retrieved element
     * @throws IndexOutOfBoundsException if this collection is empty
     */
    @Override
    public E getLast() {
        return get(size() - 1);
    }

    /**
     * Removes and returns the first element of this collection (optional operation).
     *
     * @return the removed element
     * @throws IndexOutOfBoundsException if this collection is empty
     */
    @Override
    public E removeFirst() {
        return remove(0);
    }

    /**
     * Removes and returns the last element of this collection (optional operation).
     *
     * @return the removed element
     * @throws IndexOutOfBoundsException if this collection is empty
     */
    @Override
    public E removeLast() {
        return remove(size() - 1);
    }

    @Override
    public SequencedCollection<E> reversed() {
        throw new UnsupportedOperationException();
    }
}
