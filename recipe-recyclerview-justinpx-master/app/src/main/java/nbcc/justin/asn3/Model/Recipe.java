package nbcc.justin.asn3.Model;

import java.io.Serializable;

public class Recipe implements Serializable {
    public Recipe(String name, String description, String image, String ingredients, String directions) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public String name;
    public String description;
    public String image;
    public String ingredients;
    public String directions;
}