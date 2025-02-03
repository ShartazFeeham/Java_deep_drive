package _05_collections_sequencedCollection;

import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractBetterArrayList<E> implements Collection<E> {

    /** The size of the list. */
    private int size = 0;

    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position
     */
    abstract public E get(int index);

    @Override
    public int size() {
        return size;
    }

    /**
     * Increments the size of the list by one.
     */
    protected void incrementSize() {
        size++;
    }

    /**
     * Decrements the size of the list by one.
     */
    protected void decrementSize() {
        size--;
    }

    /**
     * Returns true if the list is empty, false otherwise.
     * @return true or false depending on whether the list is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether this collection contains the specified element.
     * @param o element whose presence in this collection is to be tested
     * @return true if this collection contains the specified element, false otherwise
     */
    @Override
    public boolean contains(Object o) {
        for (E e : this) {
            if (e.equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Provides an iterator over the elements in this collection.
     * @return an iterator over this collection
     */
    @Override
    public Iterator<E> iterator() {
        return new BetterArrayListIterator();
    }

    /**
     * Removes a single instance of the specified element from this collection, if it is present.
     * @param o element to be removed from this collection, if present
     * @return true if an element was removed as a result of this call, false otherwise
     */
    @Override
    public boolean remove(Object o) {
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(o)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * Clears the list removing all elements.
     */
    @Override
    public void clear() {
        for (Iterator<E> iterator = iterator(); iterator.hasNext();) {
            iterator.next();
            iterator.remove();
        }
    }

    private class BetterArrayListIterator implements Iterator<E> {
        /**
         * The cursor is the index of the next element to return.
         * If it is equal to size, then there are no more elements to return.
         */
        int cursor = 0;

        /**
         * Checks if the iteration has more elements.
         * @return true if the iteration has more elements, false otherwise
         */
        @Override
        public boolean hasNext() {
            return size() > cursor;
        }

        /**
         * Returns the next element in the iteration.
         * @throws IndexOutOfBoundsException if there are no more elements to return
         * @return the next element in the iteration
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            return get(cursor++);
        }
    }
}
