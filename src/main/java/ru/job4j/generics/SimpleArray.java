package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable{
   private Object[]ob;
   int i = 0;
   SimpleArray(int size){
       ob = new Object[size];
   }
   public void add(T model){
       ob[Objects.checkIndex(i++,ob.length)] = model;

   }
    public void set(int index, T model){
        ob[Objects.checkIndex(index,ob.length)] = model;
    }
    public void remove (int index){
        System.arraycopy(ob,index+1,ob,index,ob.length-1-index);

    }
   public T get(int index){
       return (T) ob[Objects.checkIndex(index,ob.length)];
   }

   @Override
    public Iterator iterator() {
        return Arrays.asList(ob).iterator();
    }
}
