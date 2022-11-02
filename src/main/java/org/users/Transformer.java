package org.users;

@FunctionalInterface
public interface Transformer {
    User transformUser(User user);
}
