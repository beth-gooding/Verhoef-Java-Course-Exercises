package org.methodReferences;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.users.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MethodReferencesTests {

    @Test
    @DisplayName("Sort method based on a user's name for a collection using a comparator object")
    void sortBasedOnNameUsingComparator(){
        // arrange
        var user1 = new User(1, "Issy", "Burgundy", 5);
        var user2 = new User(2, "Sixian", "Mustard", 10);
        var user3 = new User(3, "Clarisa", "Light Blue", 15);

        // List.of will create an immutable list which is not useful here, as we need to be able to sort the list
        var usersImmutable = List.of(user1, user2, user3);

        // This list of users is mutable, which means we will be able to directly sort this list
        List<User> users = new ArrayList<>(usersImmutable);

        // act (sort)
        // using a comparator object
        Comparator<User> namesComparator = new UserComparator();
        users.sort(namesComparator);

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
        List<User> users = new ArrayList<>(usersImmutable);

        // act (sort)
        // using a comparator lambda
        users.sort((u1, u2) -> {
            return u1.getName().compareTo(u2.getName());
        });

        // assert
        assertEquals("Clarisa", users.get(0).getName());
        assertEquals("Issy", users.get(1).getName());
        assertEquals("Sixian", users.get(2).getName());

    }

    @Test
    @DisplayName("The removeIf method can remove users with names starting with S")
    void removeUsersWithNamesStartingWithS(){
        // arrange
        var user1 = new User(1, "Issy", "Burgundy", 5);
        var user2 = new User(2, "Sixian", "Mustard", 10);
        var user3 = new User(3, "Clarisa", "Light Blue", 15);

        // List.of will create an immutable list which is not useful here, as we need to be able to sort the list
        var usersImmutable = List.of(user1, user2, user3);

        // This list of users is mutable, which means we will be able to directly sort this list
        List<User> users = new ArrayList<>(usersImmutable);

        // act
        users.removeIf(user -> user.getName().startsWith("S"));

        // assert
        assertEquals(2, users.size());
        assertEquals("Issy", users.get(0).getName());
        assertEquals("Clarisa", users.get(1).getName());

    }

    @Test
    @DisplayName("The removeIf method can remove users with less than 15 points")
    void removeUsersWithLessThan15Points(){
        // arrange
        var user1 = new User(1, "Issy", "Burgundy", 5);
        var user2 = new User(2, "Sixian", "Mustard", 10);
        var user3 = new User(3, "Clarisa", "Light Blue", 15);

        // List.of will create an immutable list which is not useful here, as we need to be able to sort the list
        var usersImmutable = List.of(user1, user2, user3);

        // This list of users is mutable, which means we will be able to directly sort this list
        List<User> users = new ArrayList<>(usersImmutable);

        // act - use a lambda to say if a user has less than 15 points, remove them!
        users.removeIf(user -> user.getPoints() < 15);

        // assert
        assertEquals(1, users.size());
        assertEquals("Clarisa", users.get(0).getName());

    }

    @Test
    @DisplayName("Sort method based on a user's points for a collection using a comparator object")
    void sortMethodForPointsUsingComparator(){
        // arrange
        var user1 = new User(1, "Issy", "Burgundy", 5);
        var user2 = new User(2, "Sixian", "Mustard", 10);
        var user3 = new User(3, "Clarisa", "Light Blue", 15);

        // List.of will create an immutable list which is not useful here, as we need to be able to sort the list
        var usersImmutable = List.of(user1, user2, user3);

        // This list of users is mutable, which means we will be able to directly sort this list
        List<User> users = new ArrayList<>(usersImmutable);

        // act (sort)
        // using a comparator object
        UserComparator pointsComparator = new UserComparator();

        // We could write a lambda to call the second function on pointsComparator, but this can get quite repetitive
     //   Collections.sort(users, (u1, u2) -> {
     //       return pointsComparator.compareByPoints(u1, u2);
     //   });

        // Instead of the lines above, we can use a method reference as below. Java can pass in the parameters for you
        users.sort(pointsComparator::compareByPoints);

        // assert
        assertEquals("Clarisa", users.get(0).getName());
        assertEquals("Issy", users.get(1).getName());
        assertEquals("Sixian", users.get(2).getName());

    }

    @Test
    @DisplayName("Sort method based on a user's id for a collection using a comparator object")
    void sortMethodForIdsUsingComparator(){
        // arrange
        var user1 = new User(1, "Issy", "Burgundy", 5);
        var user2 = new User(2, "Sixian", "Mustard", 10);
        var user3 = new User(3, "Clarisa", "Light Blue", 15);

        // List.of will create an immutable list which is not useful here, as we need to be able to sort the list
        var usersImmutable = List.of(user1, user2, user3);

        // This list of users is mutable, which means we will be able to directly sort this list
        List<User> users = new ArrayList<>(usersImmutable);

        // act (sort)
        // If we have a static method, we refer to the class rather than an object of the class for method references
        users.sort(UserComparator::compareById);

        // assert
        assertEquals("Clarisa", users.get(0).getName());
        assertEquals("Issy", users.get(1).getName());
        assertEquals("Sixian", users.get(2).getName());

    }

}
