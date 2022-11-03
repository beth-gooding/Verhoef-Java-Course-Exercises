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

        Repository<User> repository = new Repository();

        // act
        repository.save(u1);
        List<User> savedUsers = repository.findAll();

        // assert
        assertEquals(savedUsers.get(0).getId(), u1.getId());
        assertEquals(savedUsers.get(0).getName(), u1.getName());
    }
}
