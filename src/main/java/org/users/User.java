package org.users;

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


}
