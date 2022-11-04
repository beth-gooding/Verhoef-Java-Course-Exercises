package org.methodReferences;

import org.users.User;

import java.util.Comparator;

public class UserComparator implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return user1.getName().compareTo(user2.getName());
    }

    public int compareByPoints(User user1, User user2) {
        return user1.getName().compareTo(user2.getName());
    }

    static public int compareById(User user1, User user2) {
        return user1.getName().compareTo(user2.getName());
    }
}
