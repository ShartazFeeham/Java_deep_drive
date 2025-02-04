package _05_collections_sequencedCollection;

import java.util.ArrayList;
import java.util.List;

public class IncrementingArrayList<E> extends AbstractSequencedIncrementingArrayList<E> {

    public static final int DEFAULT_BUCKET_CAPACITY = 100;
    private static int CAPACITY_PER_ROW;
    private final Object [] elements = new Object[CAPACITY_PER_ROW];
    private final List<E[]> rows;

    public IncrementingArrayList() {
        rows = new ArrayList<>();
        CAPACITY_PER_ROW = DEFAULT_BUCKET_CAPACITY;
    }

    public IncrementingArrayList(int bucketCapacity) {
        rows = new ArrayList<>();
        CAPACITY_PER_ROW = bucketCapacity;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index                         index of the element to return
     * @throws IndexOutOfBoundsException    if there are no more elements to return
     * @throws NullPointerException         if the specified element is null and this
     * @return                              the element at the specified position
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        int row = index / CAPACITY_PER_ROW;
        int col = index % CAPACITY_PER_ROW;
        return rows.get(row)[col];
    }

    /**
     * Adds the specified element to this collection at the specified index.
     *
     * @param index                         index at which the specified element is to be inserted
     * @param o                             element to be added to this collection
     * @throws IndexOutOfBoundsException    if there are no more elements to return
     * @throws NullPointerException         if the specified element is null and this
     * @return                              true if this collection changed as a result of the call, false otherwise
     */
    @Override
    protected boolean add(int index, Object o) {
        if (o == null) {
            throw new NullPointerException("This collection does not permit null elements!");
        }
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }

        int row = index / CAPACITY_PER_ROW;
        int col = index % CAPACITY_PER_ROW;

        E[] elements = rows.get(row);
        if (elements == null) {
            elements = (E[]) new Object[CAPACITY_PER_ROW];
            rows.add(row, elements);
        }
        rows.get(row)[col] = convertItem(o);
        incrementSize();
        return true;
    }

    /**
     * Attempts to remove an item at the specified index. However, the incrementing list is not supposed
     * to remove elements. As a result, this method throws an UnsupportedOperationException.
     *
     * @param index                             position of the element to be removed
     * @throws UnsupportedOperationException    if an attempt is made to remove an element
     * @return                                  the element that was removed
     */
    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("This list is increment only and does not support removal!");
    }

    private E convertItem(Object o) {
        if (o == null) {
            throw new ClassCastException("The object is not of the correct type!");
        }
        return (E) o;
    }
}
