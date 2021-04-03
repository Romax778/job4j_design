package ru.job4j.generics;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
    mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        for(int i = 0; i< mem.size();i++) {
            if(Objects.equals(mem.get(i).getId(),id)){
             int replaceIndex = mem.indexOf(mem.get(i));
             mem.set(replaceIndex,model);
             return true;
            }
        }

        return false;
    }

    @Override
    public boolean delete(String id) {
        for(int i = 0; i< mem.size();i++) {
            if(Objects.equals(mem.get(i).getId(),id)){
                int deleteIndex = mem.indexOf(mem.get(i));
                mem.remove(deleteIndex);
                return true;
            }
        }
        return false;
    }

    @Override
    public T findById(String id) {
        for(int i = 0; i< mem.size();i++) {
            if(Objects.equals(mem.get(i).getId(),id)){
                return mem.get(i);
            }
        }
        return null;
    }
}
