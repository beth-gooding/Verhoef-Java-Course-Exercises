package org.users;

public class User {
    private int id;
    private String name;
    private String favouriteColour;

    private void setId(int newId) {
        id = newId;
    }

    private void setName(String newName) {
        name = newName;
    }

    private void setFavouriteColour(String newFavouriteColour) {
        favouriteColour = newFavouriteColour;
    }

    public void setProperties(int id, String name, String favouriteColour) {
        setId(id);
        setName(name);
        setFavouriteColour(favouriteColour);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFavouriteColour() {
        return favouriteColour;
    }
}
