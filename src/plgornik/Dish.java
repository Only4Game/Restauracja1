package plgornik;

import java.util.Arrays;

public class Dish {
    private String name;
    private String[] ingredients;
    private Double cost;

    private String type;
    private DishType dishType;

    public Dish(String name, String[] ingredients, Double cost, String type, DishType dishType) {
        this.name = name;
        this.ingredients = ingredients;
        this.cost = cost;
        this.type = type;
        this.dishType = dishType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }

    public void displayInfo() {
        System.out.println("\n\n========================\n" +
                type +
                "\n========================\n" +
                "Dish Name: " + name + "\n" +
                "========================\n" +
                "Ingredients: " + Arrays.toString(ingredients) +"\n" +
                "\n Dish type: " + dishType + "\n Cost: " + cost + " £\n========================");
    }

    public void changeIngredients(String[] newIngredientList){
        this.ingredients = newIngredientList;
    }
}
