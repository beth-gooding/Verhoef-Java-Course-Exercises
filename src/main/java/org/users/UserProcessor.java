package org.users;

import java.util.List;
import java.util.stream.Collectors;

public class UserProcessor {
    public List<User> filter(List<User> userList, String colour) {

        return userList.stream()
                .filter(user -> user.getFavouriteColour().equalsIgnoreCase(colour))
                .collect(Collectors.toList());

    }
}
