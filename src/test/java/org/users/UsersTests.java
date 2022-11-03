package org.users;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class UsersTests {

    @Test
    @DisplayName("A user has the expected id, name, and favourite colour")
    void expectedUserProperties() {
        // arrange
        User user = new User(1, "Beth", "red", 5);
        int expectedId = 1;
        String expectedName = "Beth";
        String expectedFavouriteColour = "Red";

        // act
        int actualId = user.getId();
        String actualName = user.getName();
        String actualFavouriteColour = user.getFavouriteColour();

        // assert
        assertEquals(expectedId, actualId);
        assertEquals(expectedName, actualName);
        assertEquals(expectedFavouriteColour, actualFavouriteColour);
    }

    @Test
    @DisplayName("The user processor can filter a list of users by colour")
    void filterByColour() {
        // arrange
        UserProcessor userProcessor = new UserProcessor();
        ColourFinder colourFinder = new ColourFinder();

        User user1 = new User(1, "Player1", "red", 5);
        User user2 = new User(2, "Player2", "blue", 5);
        User user3 = new User(3, "Player3", "blue", 5);

        List<User> userList = List.of(user1, user2, user3);
        List<User> expectedFilteredList = List.of(user2, user3);

        // act
        List<User> actualFilteredList =
                userProcessor.genericFilter(userList, colourFinder,"blue");
        // assert
        assertEquals(expectedFilteredList, actualFilteredList);
    }

    @Test
    @DisplayName("UserProcessor can transform the user details")
    void UserProcessorCanTransformUserDetails() {
        var user1 = new User(1, "Issy", "Burgundy", 5);
        var user2 = new User(2, "Sixian", "Mustard", 5);
        var user3 = new User(3, "Clarisa", "Light Blue", 5);

        List<User> untransformedUsers = List.of(user1, user2, user3);

        var addFivePointsTransformer = new AddFivePointsTransformer();

        // act
        List<User> actualTransformedUsers = UserProcessor.transformUser(untransformedUsers, addFivePointsTransformer);

        // assert
        assertEquals( 10, actualTransformedUsers.get(0).getPoints());
        assertEquals(10, actualTransformedUsers.get(1).getPoints());
        assertEquals(10, actualTransformedUsers.get(2).getPoints());
    }

}