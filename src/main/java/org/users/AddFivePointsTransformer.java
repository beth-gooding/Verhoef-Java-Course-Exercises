package org.users;

public class AddFivePointsTransformer implements Transformer{

    @Override
    public User transformUser(User user) {
        user.setPoints(user.getPoints() + 5);
        return user;
    }
}
