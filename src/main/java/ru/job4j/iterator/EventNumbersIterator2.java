package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EventNumbersIterator2 implements Iterator<Integer> {
    private final int[] data;
    int position = 0;

    public EventNumbersIterator2(int[] data) {
        this.data = data;
    }

    Integer result;

    @Override
    public boolean hasNext() {

        boolean hasNext = false;
        for (int i = position; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                hasNext = true;
                break;
            }
            result = data[position++];
        }
        return hasNext;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[position++];
    }
}