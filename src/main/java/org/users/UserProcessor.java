package org.users;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserProcessor {
    Finder colourLambda = (user, colour) -> user.getFavouriteColour().equals(colour);
    public static List<User> genericFilter(List<User> userList, Finder finder, String filterParameter) {
        return userList.stream().filter(user -> finder.test(user, filterParameter)).collect(Collectors.toList());
    }

    public static List<User> transformUser(List<User> users, Transformer transformer) {
      ArrayList<User> transformedList = new ArrayList<>();
      for (User user: users) {
          transformedList.add(transformer.transformUser(user));
      }
      return transformedList;
    }
}
