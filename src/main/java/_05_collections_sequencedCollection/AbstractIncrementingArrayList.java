package _05_collections_sequencedCollection;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.SequencedCollection;

public abstract class AbstractIncrementingArrayList<E> implements Collection<E>, SequencedCollection<E> {

    /** The size of the list. */
    private int size = 0;

    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @throws IndexOutOfBoundsException if there are no more elements to return
     * @return the element at the specified position
     */
    abstract public E get(int index);

    /**
     * Provides the current number of elements in the list.
     * @return the size of the list
     */
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
        return indexOf(o) != -1;
    }

    private int indexOf(Object o) {
        int index = 0;
        for (E e : this) {
            if (e.equals(o)) {
                return index;
            }
            index++;
        }
        return -1;
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
        int index = indexOf(o);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * Removes the item in the index, if it is present.
     * @param index position of the element to be removed
     * @throws IndexOutOfBoundsException if there are no more elements to return
     * @return the element that was removed
     */
    abstract public E remove(int index);

    /**
     * Checks whether all the elements in the specified collection are contained in this collection.
     * @param collection collection to be checked for containment in this collection
     * @return true if this collection contains all the elements in the specified collection, false otherwise
     */
    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object o : collection) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds the specified element to this collection.
     * @param e element to be added to this collection
     * @return true if this collection changed as a result of the call, false otherwise
     */
    @Override
    public boolean add(E e) {
        return add(size(), e);
    }

    /**
     * Adds the specified element to this collection at the specified index.
     * @param index index at which the specified element is to be inserted
     * @param e element to be added to this collection
     * @return true if this collection changed as a result of the call, false otherwise
     */
    abstract protected boolean add(int index, E e);

    /**
     * Adds the specified element to this collection.
     * @param collection elements to be added to this collection
     * @return true if this collection changed as a result of the call, false otherwise
     */
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean modified = false;
        for (E e : collection) {
            if (add(e)) {
                modified = true;
            }
        }
        return modified;
    }

    /**
     * Removes all the items in the specified collection from this collection.
     * @param collection element to be removed from this collection
     * @return true if this collection changed as a result of the call, false otherwise
     */
    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean modified = false;
        for (Object o : collection) {
            modified = remove(o) || modified;
        }
        return modified;
    }

    /**
     * Retains only the elements in this collection that are contained in the specified collection.
     * @param collection collection containing elements to be retained in this collection
     * @return true if this collection changed as a result of the call, false otherwise
     */
    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean modified = false;
        for (Iterator<E> iterator = iterator(); iterator.hasNext();) {
            if (!collection.contains(iterator.next())) {
                iterator.remove();
                modified = true;
            }
        }
        return modified;
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

    /**
     * Returns an array containing all the elements in this collection.
     * @return an array containing all the elements in this collection
     */
    @Override
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    /**
     * Returns an array containing all the elements in this collection.
     * @param a the array into which the elements of this collection are to be stored, if it is big enough;
     *          otherwise, a new array of the same runtime type is allocated for this purpose
     * @return an array containing all the elements in this collection
     */
    @Override
    public Object[] toArray(Object[] a) {
        if (a.length < size()) {
            a = new Object[size()];
        }
        for (int i = 0; i < size(); i++) {
            a[i] = get(i);
        }
        return a;
    }

    private class BetterArrayListIterator implements ListIterator<E> {
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

        /**
         * Checks if the iteration has more elements in the reverse direction.
         * @return true if the iteration has more elements in the reverse direction, false otherwise
         */
        @Override
        public boolean hasPrevious() {
            return cursor > 0;
        }

        /**
         * Returns the previous element in the iteration.
         * @throws IndexOutOfBoundsException if there are no more elements to return
         * @return the previous element in the iteration
         */
        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new IndexOutOfBoundsException();
            }
            return get(--cursor);
        }

        /**
         * Returns the index of the element that would be returned by a subsequent call to next.
         * @return the next index
         */
        @Override
        public int nextIndex() {
            return cursor + 1;
        }

        /**
         * Returns the index of the element that would be returned by a subsequent call to previous.
         * @return the previous index
         */
        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        /**
         * Removes from the list the last element that was returned by next or previous.
         */
        @Override
        public void remove() {
            AbstractIncrementingArrayList.this.remove(cursor);
        }

        @Override
        public void set(E e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException();
        }
    }
}
