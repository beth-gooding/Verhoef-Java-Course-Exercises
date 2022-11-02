package org.users;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class UsersTests {

    @Test
    @DisplayName("A user has the expected id, name, and favourite colour")
    void expectedUserProperties() {
        // arrange
        User user = new User();
        int expectedId = 1;
        String expectedName = "Beth";
        String expectedFavouriteColour = "Red";

        // act
        user.setProperties(expectedId, expectedName, expectedFavouriteColour);
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

        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        user1.setProperties(1, "Player1", "red");
        user2.setProperties(2, "Player2", "blue");
        user3.setProperties(3, "Player3", "blue");


        List<User> userList = Arrays.asList(user1, user2, user3);
        List<User> expectedFilteredList = Arrays.asList(user2, user3);

        // act
        List<User> actualFilteredList = userProcessor.genericFilter(userList, colourFinder,"blue");
        // assert
        assertEquals(expectedFilteredList, actualFilteredList);
    }

}