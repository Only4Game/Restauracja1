package plgornik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Restaurant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //stworzenie podstawowej listy z daniami (menu)

        List<Dish> dishList = new ArrayList<>();
        initializeDishes(dishList);

        showMenu();

        //algorytm koszyka oraz wybór zamawianych dań razem z możliwością zmiany składników

        String choice = "Yes";
        String dishName;
        List<Dish> basket = new ArrayList<>();
        while (choice.equalsIgnoreCase("Yes") || choice.equalsIgnoreCase("Y")) {
            boolean isFind = false;
            System.out.println("\n\n\n\n\n===================================");
            System.out.println("===================================");
            System.out.println("Which dish would you like to order?");
            System.out.println("===================================");
            System.out.println("===================================");
            System.out.println("Write name of the dish from menu:");
            System.out.println("===================================");
            dishName = scanner.nextLine();
            for (Dish dish : dishList) {
                if (dish.getName().equalsIgnoreCase(dishName)) {

                    //metoda zmiany składników

                    System.out.println("\n\n\n===================================");
                    System.out.println("Would you like to change ingredients?");
                    System.out.println("===================================");
                    System.out.println("(If you want write Yes/Y)");
                    System.out.println("===================================");
                    String ingredientsChoice = scanner.nextLine();
                    if (ingredientsChoice.equalsIgnoreCase("Yes") || ingredientsChoice.equalsIgnoreCase("Y")) {
                        System.out.println("\n\n\n===================================");
                        System.out.println("Dish ingredients:");
                        System.out.println(Arrays.toString(dish.getIngredients()));
                        System.out.println("===================================");
                        System.out.println("Write down ingredients would you like");
                        System.out.println("to have in your dish (use comma sign)");
                        System.out.println("===================================");
                        String[] newIngredientsList = new String[]{scanner.nextLine()};
                        dish.changeIngredients(newIngredientsList);
                    }
                    basket.add(dish);
                    isFind = true;
                }
            }
            if (!isFind) System.out.println("Sorry, we don't have dish with this name in our menu");
            System.out.println("Would you like to order anything else? (If you want write Yes/Y)");
            choice = scanner.nextLine();
        }

        //Podsumowanie koszyka oraz całkowita cena zamówienia

        double totalPrice = 0;
        System.out.println("\n\n\n\n\n===================================");
        System.out.println("===================================");
        System.out.println("Your on-line dish basket");
        System.out.println("===================================");
        System.out.println("===================================");
        for (Dish dish : basket) {
            System.out.println(dish.getName());
            System.out.println(Arrays.toString(dish.getIngredients()));
            System.out.println(dish.getCost() + " £");
            System.out.println("-----------------------------------");
            totalPrice += dish.getCost();

        }
        System.out.println("===================================");
        System.out.println("Total price of dishes: " + totalPrice + " £");
        System.out.println("===================================");

        //metoda dzięki której możemy usunąć produkt z koszyka

        System.out.println("\n\n\n===================================");
        System.out.println("===================================");
        System.out.println("Would you like to delete anything?");
        System.out.println("===================================");
        System.out.println("===================================");
        System.out.println("(If you want write Yes/Y)");
        System.out.println("===================================");
        List<Dish> newBasket = new ArrayList<>(basket);
        String choice1 = scanner.nextLine();
        while (choice1.equalsIgnoreCase("Yes") || choice1.equalsIgnoreCase("Y")) {
            boolean isFind1 = false;
            System.out.println("\n\n\n===================================");
            System.out.println("Write down name of dish from your");
            System.out.println("basket you want to delete");
            System.out.println("===================================");
            String dishName1 = scanner.nextLine();
            for (Dish dish1 : basket) {
                if (dish1.getName().equalsIgnoreCase(dishName1)) {
                    newBasket.remove(dish1);
                    isFind1 = true;
                }
            }
            if (!isFind1) System.out.println("\n\n\nSorry, you don't have dish with this name in your basket");
            System.out.println("Would you like to delete anything else? (If you want write Yes/Y)");
            choice1 = scanner.nextLine();
        }

        //Finałowy koszyk razem z ceną

        double newTotalPrice = 0;
        System.out.println("\n\n\n\n\n===================================");
        System.out.println("===================================");
        System.out.println("Your on-line dish basket");
        System.out.println("===================================");
        System.out.println("===================================");
        for (Dish dish : newBasket) {
            System.out.println(dish.getName());
            System.out.println(Arrays.toString(dish.getIngredients()));
            System.out.println(dish.getCost() + " £");
            System.out.println("-----------------------------------");
            newTotalPrice += dish.getCost();

        }
        System.out.println("===================================");
        System.out.println("Total price of dishes: " + newTotalPrice + " £");
        System.out.println("===================================");

        //Ostatnie potwierdzenie dokonania zamówienia

        System.out.println("\n\n\n\n\n===================================");
        System.out.println("Complete order by writing Yes or Y");
        System.out.println("===================================");
        String orderChoice = scanner.nextLine();
        if (orderChoice.equalsIgnoreCase("Yes") || orderChoice.equalsIgnoreCase("Y")){
            System.out.println("=============================");
            System.out.println("Recipt number: " + (int)(Math.random()*(999999-100000)+100000));
            System.out.println("=============================");
            System.out.println("Your items:");
            for(Dish dish: newBasket){
                System.out.println(dish.getName() + " - " + dish.getCost() + " £");
                System.out.println(" ");
            }
            System.out.println("=============================");
            System.out.println("Total price : " + newTotalPrice + " £");
            System.out.println("=============================");
            System.out.println("Thanks for your order! Enjoy your meal!");
            System.out.println("=============================");
        }
        else{
            System.out.println("=============================");
            System.out.println("Order cancelled");
            System.out.println("=============================");
        }

    }

    public static void showMenu() {

        //Metoda pokazująca nam dostępne potrawy (Menu)

        List<Dish> dishList = new ArrayList<>();
        initializeDishes(dishList);

        for (Dish dish : dishList) {
            dish.displayInfo();
        }
    }

    public static void initializeDishes(List<Dish> dishes) {

        //Inicjalizacja danych do listy (potrawy)

        dishes.add(new Dish("California Roll", new String[]{"Crab", "avocado", "toasted sesame", "rice"}, 19.00, "Starter", DishType.Fish));
        dishes.add(new Dish("Beetroot & Rhubarb Tartare", new String[]{"Beetroot", "vegan stracciatella", "almond", "sumac"}, 10.00, "Starter", DishType.Vegan));
        dishes.add(new Dish("Caesar Salad", new String[]{"Parmesan", "croutons", "egg", "anchovies"}, 12.50, "Starter", DishType.Fish));
        dishes.add(new Dish("Aged Beef Tartare", new String[]{"Aged beef", "St Ewes egg", "grilled sourdough"}, 16.50, "Starter", DishType.Beef));
        dishes.add(new Dish("Seabass Ceviche", new String[]{"Avocado", "pickled grapes", "ponzu dressing"}, 18.00, "Starter", DishType.Vegetarian));

        dishes.add(new Dish("Beef Wellington", new String[]{"Mash", "red wine jus", "beef"}, 115.00, "Main", DishType.Beef));
        dishes.add(new Dish("Scottish Lobster Roll", new String[]{"Capers", "avocado", "lobster", "fries"}, 44.00, "Main", DishType.Fish));
        dishes.add(new Dish("Scialatielli Pasta", new String[]{"Vegan nduja", "tomato", "garlic breadcrumbs", "pasta"}, 21.00, "Main", DishType.Vegan));
        dishes.add(new Dish("Grill Cheeseburger", new String[]{"beef", "house pickles", "burger sauce", "fries"}, 23.00, "Main", DishType.Beef));
        dishes.add(new Dish("Roasted Chicken Leg", new String[]{"Beetroot mash", "toasted sesame", "chicken", "almond"}, 31.50, "Main", DishType.Chicken));
        dishes.add(new Dish("Vegan Burger", new String[]{"cheedar cheese", "house pickles", "burger sauce", "fries"}, 21.00, "Main", DishType.Vegetarian));
        dishes.add(new Dish("Mac & cheese", new String[]{"Pasta", "cheedar cheese", "parmesan", "pasta", "crispy bacon"}, 22.00, "Main", DishType.Pork));

        dishes.add(new Dish("Toffee Pudding", new String[]{"Milk ice-cream", "toffee", "pudding cake"}, 11.00, "Dessert", DishType.Vegetarian));
        dishes.add(new Dish("Tropical Fruit Sundae", new String[]{"Tropical fruit compote", "sorbets", "coconut foam", "biscoff crumb"}, 10.50, "Dessert", DishType.Vegetarian));
        dishes.add(new Dish("Black Forest Cheesecake", new String[]{"Cherry compote", "pistachio ice-cream", "cheesecake"}, 10.50, "Dessert", DishType.Vegetarian));
        dishes.add(new Dish("70% Chocolate Brownie", new String[]{"Hazelnut praline", "vanilla ice-cream", "brownie cake"}, 11.00, "Dessert", DishType.Vegetarian));
        dishes.add(new Dish("Selection of Artisan Cheeses", new String[]{"House chutney", "seeded cracker", "cheese"}, 13.75, "Dessert", DishType.Vegetarian));
    }
}
