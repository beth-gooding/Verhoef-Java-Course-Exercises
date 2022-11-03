package org.generic;

import org.users.User;

import java.util.ArrayList;
import java.util.List;

// The <T> tells the compiler that this is a generic class that needs one type
public class Repository<T> {

    List<T> list = new ArrayList<>();

    // Here the type is replaced by T as we don't know what type the object will have yet
    public void save(T item) {
        list.add(item);
    }

    // Again, we don't know return type of this function yet, just that it will be the same as the type of what we save
    public List<T> findAll() {
        return list;
    }

//    public T findById(int i) {
//        for(T item: list){
//            if (item)
//        }
//    }
}

class RepositoryUtility {
    // You can keep another class in here to support the public class, but you don't want it to be public
    private List<User> list = new ArrayList<>();
}
