package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    Object[] container = new Object[3];
    int modCount;

    public SimpleArray() {

    }

    public SimpleArray(int size) {
        container = new Object[size];
    }

    int currentIndex = 0;

    public T get(int index) {

        return (T) container[Objects.checkIndex(index, currentIndex)];
    }

    public void add(T model) {
        if (container.length == currentIndex) {
            Object[] temp = new Object[container.length * 2];
            System.arraycopy(container, 0, temp, 0, container.length);
            container = temp;
        }
        container[currentIndex++] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {


        return (Iterator<T>) new SimpleArrayIterator();
    }

    class SimpleArrayIterator implements Iterator<Object> {
        int counter = 0;
        int expectedModCount;

        SimpleArrayIterator() {
            expectedModCount = modCount;

        }

        @Override
        public boolean hasNext() {
            if (counter < currentIndex) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return container[counter++];

        }

    }
}