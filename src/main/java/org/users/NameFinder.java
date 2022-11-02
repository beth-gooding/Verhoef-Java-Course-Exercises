package org.users;

public class NameFinder implements Finder {
    @Override
    public boolean test(User user, String name) {
        if (user.getName().equals(name)) {
            return true;
        } else {
            return false;
        }
    }
}
