package org.users;

import java.util.List;

public class ColourFinder implements Finder {
    @Override
    public boolean test(User user, String colour) {
        return user.getFavouriteColour().equalsIgnoreCase(colour);
    }
}
