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
    public int getIndexById(String id){
        for(int i = 0; i< mem.size();i++) {
            if(Objects.equals(mem.get(i).getId(),id)){
                int index = mem.indexOf(mem.get(i));

                return index;
            }
        }return -1;
    }

    @Override
    public boolean replace(String id, T model) {
        int replaceIndex = getIndexById(id);
        if(replaceIndex!=-1){

             mem.set(replaceIndex,model);
             return true;
            }


        return false;
    }

    @Override
    public boolean delete(String id) {
        int deleteIndex = getIndexById(id);
        if(deleteIndex!=-1){
                mem.remove(deleteIndex);
                return true;
            }

        return false;
    }

    @Override
    public T findById(String id) {
        int index = getIndexById(id);
        if(index!=-1){
                return mem.get(index);
            }

        return null;
    }
}
