package org.methodReferences;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.users.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodReferencesTests {

    @Test
    @DisplayName("Sort method for a collection using a comparator object")
    void sortMethodForCollectionsUsingComparator(){
        // arrange
        var user1 = new User(1, "Issy", "Burgundy", 5);
        var user2 = new User(2, "Sixian", "Mustard", 10);
        var user3 = new User(3, "Clarisa", "Light Blue", 15);

        // List.of will create an immutable list which is not useful here, as we need to be able to sort the list
        var usersImmutable = List.of(user1, user2, user3);

        // This list of users is mutable, which means we will be able to directly sort this list
        List<User> users = new ArrayList<>();
        users.addAll(usersImmutable);


        var expectedSortedUser = List.of(user3, user2, user1);

        // act (sort)
        // using a comparator object
        Comparator<User> namesComparator = new UserComparator();
        Collections.sort(users, namesComparator);

        // assert
        assertEquals("Clarisa", users.get(0).getName());
        assertEquals("Issy", users.get(1).getName());
        assertEquals("Sixian", users.get(2).getName());

    }

    @Test
    @DisplayName("Sort method for a collection using a lambda")
    void sortMethodForCollectionsUsingLambda(){
        // arrange
        var user1 = new User(1, "Issy", "Burgundy", 5);
        var user2 = new User(2, "Sixian", "Mustard", 10);
        var user3 = new User(3, "Clarisa", "Light Blue", 15);

        // List.of will create an immutable list which is not useful here, as we need to be able to sort the list
        var usersImmutable = List.of(user1, user2, user3);

        // This list of users is mutable, which means we will be able to directly sort this list
        List<User> users = new ArrayList<>();
        users.addAll(usersImmutable);


        var expectedSortedUser = List.of(user3, user2, user1);

        // act (sort)
        // using a comparator lambda
        Collections.sort(users, (u1, u2) -> {return u1.getName().compareTo(u2.getName());});

        // assert
        assertEquals("Clarisa", users.get(0).getName());
        assertEquals("Issy", users.get(1).getName());
        assertEquals("Sixian", users.get(2).getName());

    }
}
