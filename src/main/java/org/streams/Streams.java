package org.streams;

import org.users.User;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Streams {
    // TODO: try and create the invoice example from the class miro-board
    public static List<User> filter (List<User> users, String filterColour) {
        Predicate<User> byColour =  user -> user.getFavouriteColour() == filterColour;

        var result = users.stream() // Put everything in users into a stream
                .filter(byColour) // filter the objects based on the byColour lambda function
                .map(user -> user) // map the objects in some way (just for illustration)
                .collect(Collectors.toList()); // do something to all the objects together

        return result;
    }
}
