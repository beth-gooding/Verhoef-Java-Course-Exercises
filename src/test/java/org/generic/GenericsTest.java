package org.generic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.users.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenericsTest {
    @Test
    @DisplayName("Generic types can be realised with a variety of types")
    void genericTypesCanBeRealised() {
        // arrange
        var u1 = new User(1, "Beth", "red", 0);
        var u2 = new User(2, "David", "Green", 0);

        Repository<User> repository = new Repository();

        // act
        repository.save(u1);
        List<User> savedUsers = repository.findAll();

        // assert
        assertEquals(savedUsers.get(0).getId(), u1.getId());
        assertEquals(savedUsers.get(0).getName(), u1.getName());

        // Ideally, we want to do this, which we have done by overriding the hashcode method for the user class:
        assertEquals(savedUsers.get(0), u1);

        // Instead for now we need to get the objects to compare themselves and see if they are equal
        // We have overridden the equals method inside the user class to define a sensible implementation for users
        u1.equals(u2);
    }
}
