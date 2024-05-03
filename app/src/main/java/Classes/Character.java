package Classes;

import java.io.Serializable;

public class Character implements Serializable {
    private String name;
    private boolean alive;
    private String species;
    private String earth;
    private String sex;
    private String location;
    private String imageUrl;

    public Character(String name, boolean alive, String species, String earth, String sex, String location, String imageUrl) {
        this.name = name;
        this.alive = alive;
        this.species = species;
        this.earth = earth;
        this.sex = sex;
        this.location = location;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return alive;
    }

    public String getSpecies() {
        return species;
    }

    public String getEarth() {
        return earth;
    }

    public String getSex() {
        return sex;
    }

    public String getLocation() {
        return location;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
