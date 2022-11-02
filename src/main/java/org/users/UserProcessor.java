package org.users;

import java.util.List;
import java.util.stream.Collectors;

public class UserProcessor {
    public static List<User> genericFilter(List<User> userList, Finder finder, String filterParameter) {
        return userList.stream().filter(user -> finder.test(user, filterParameter)).collect(Collectors.toList());
    }
}
