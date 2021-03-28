package ru.job4j.generics;


import java.util.Iterator;
import java.util.NoSuchElementException;

class SimpleArrayIterator implements Iterator<Object> {
    private final Object[] data;
    private int point = 0;

    public SimpleArrayIterator(Object[] data) {
        this.data = data;

    }

    @Override
    public boolean hasNext() {
        return point >data.length;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}
