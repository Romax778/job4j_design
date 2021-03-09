package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;
    int currentPosition = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if(data == null && data.length == 0){
            return false;
        }
        boolean isEmpty = true;
        for(int[] arr : data){
            if(arr.length != 0){
                isEmpty = false;
            }
        }
        if(isEmpty){
            return false;
        }
         return row < data.length && column <= data[row].length ;

    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();

        }

        if(data[row].length == column || data[row].length==0){
while (data[row].length==0) {
    row++;
    column = 0;
}
        }

        Integer result = data[row][column++];
        if(data[row].length == column){
            row++;
            column = 0;
        }

        return result;
    }
}
