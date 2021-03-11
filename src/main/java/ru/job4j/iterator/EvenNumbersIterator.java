package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    int position = 0;
    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {

        boolean hasNext = false;
        for (int i = position; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                hasNext = true;
                break;
            }
        }
        return hasNext;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (position < data.length) {
            if (data[position] % 2 == 0) {
                break;
            }
            position++;
        }
        Integer result = data[position++];
        return result;
    }
}