package org.users;

import java.util.Objects;

public class User {
    private int id;
    private String name;
    private String favouriteColour;

    private int points = 0;

    public User(int id, String name, String favouriteColour, int points) {
        this.id = id;
        this.name = name;
        this.favouriteColour = favouriteColour;
        this.points = points;
    }

    private void setId(int newId) {
        id = newId;
    }

    private void setName(String newName) {
        name = newName;
    }

    private void setFavouriteColour(String newFavouriteColour) {
        favouriteColour = newFavouriteColour;
    }

    public void setPoints(int newPoints) {
        points = newPoints;
    }
    public void setProperties(int id, String name, String favouriteColour, int points) {
        setId(id);
        setName(name);
        setFavouriteColour(favouriteColour);
        setPoints(points);
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

    public int getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {

        // if it is in the same place in memory, return true
        if (this == o) return true;

        // if the object is null or the class of the object is not the same as this objects class (user) return false
        if (o == null || getClass() != o.getClass()) return false;

        // cast o to be a User object and check if the id and name of the User object are the same as the current user
        User user = (User) o;
        return id == user.id && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
